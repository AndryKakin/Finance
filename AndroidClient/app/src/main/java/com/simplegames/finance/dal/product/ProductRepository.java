package com.simplegames.finance.dal.product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.simplegames.finance.dal.DB.FinanceDataBase;
import com.simplegames.finance.dal.Common.IRepository;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class ProductRepository implements IRepository<Product> {
    private FinanceDataBase _financeDataBase;
    private ProductTable _productTable = new ProductTable();

    public ProductRepository(Context context)
    {
        _financeDataBase = new FinanceDataBase(context);
    }

    @Override
    public void Add(Product product) {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(_productTable.NameColumnName, product.Name);
        cv.put(_productTable.DescriptionColumnName,product.Description);

        ByteArrayOutputStream memory = new ByteArrayOutputStream();
        product.Bitmap.compress(Bitmap.CompressFormat.JPEG, 100, memory);
        cv.put(_productTable.Image, memory.toByteArray());

        product.Id = sqdb.insert(ProductTable.TableName, null, cv);
        sqdb.close();
    }

    @Override
    public void Remove(Product item) {

    }

    @Override
    public void Update(Product item) {

    }

    @Override
    public ArrayList<Product> GetAll() {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        Cursor cursor = sqdb.query(ProductTable.TableName, new String[] {
                        _productTable.IdColumnName,
                        _productTable.NameColumnName,
                        _productTable.DescriptionColumnName,
                        _productTable.Image},
                null, // The columns for the WHERE clause
                null, // The values for the WHERE clause
                null, // don't group the rows
                null, // don't filter by row groups
                null // The sort order
        );
        ArrayList<Product> result = new ArrayList<Product>();
        while (cursor.moveToNext()) {
            // GET COLUMN INDICES + VALUES OF THOSE COLUMNS
            long id = cursor.getInt(cursor
                    .getColumnIndex(_productTable.IdColumnName));

            String name = cursor.getString(cursor.getColumnIndex(_productTable.NameColumnName));

            String description = cursor.getString(cursor.getColumnIndex(_productTable.DescriptionColumnName));

            byte[] data = cursor.getBlob(cursor.getColumnIndex(_productTable.Image));

            Log.i("LOG_TAG", "ROW " + id + " NAME " + name + " DESCRIPTION " + description);
            Product product = new Product();
            product.Id = id;
            product.Name = name;
            product.Description = description;
            product.Bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            result.add(product);
        }
        cursor.close();
        return result;
    }
}
