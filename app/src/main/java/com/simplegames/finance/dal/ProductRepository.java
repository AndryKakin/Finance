package com.simplegames.finance.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.simplegames.finance.models.Product;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class ProductRepository implements IRepository<Product> {
    private FinanceDataBase _financeDataBase;
    public ProductRepository(Context context)
    {
        _financeDataBase = new FinanceDataBase(context);
    }
    @Override
    public void Add(Product item) {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ProductTable.NameColumnName, item.Name);
        cv.put(ProductTable.DescriptionColumnName,item.Description);
        sqdb.insert(ProductTable.TableName, null, cv);
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
                ProductTable.IdColumnName,
                ProductTable.NameColumnName,
                ProductTable.DescriptionColumnName},
                null, // The columns for the WHERE clause
                null, // The values for the WHERE clause
                null, // don't group the rows
                null, // don't filter by row groups
                null // The sort order
        );
        while (cursor.moveToNext()) {
            // GET COLUMN INDICES + VALUES OF THOSE COLUMNS
            int id = cursor.getInt(cursor.getColumnIndex(ProductTable.IdColumnName));
            String name = cursor.getString(cursor
                    .getColumnIndex(ProductTable.NameColumnName));
            Log.i("LOG_TAG", "ROW " + id + " HAS NAME " + name);

        }
        cursor.close();
        return null;
    }
}
