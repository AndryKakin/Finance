package com.simplegames.finance.dal.operationItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.simplegames.finance.dal.DB.FinanceDataBase;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.operation.OperationTable;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by andrey.kakin on 16.10.2014.
 */
public class OperationItemRepository implements IRepository<OperationItem> {
    private FinanceDataBase _financeDataBase;
    private OperationItemTable _operationItemTable = new OperationItemTable();

    public OperationItemRepository(Context context)
    {
        _financeDataBase = new FinanceDataBase(context);
    }

    @Override
    public void Add(OperationItem operationItem) {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(_operationItemTable.OperationIdColumnName, operationItem.OperationId);
        cv.put(_operationItemTable.ProductIdColumnName, operationItem.ProductId);
        cv.put(_operationItemTable.CountOfProductsName, operationItem.Count);
        cv.put(_operationItemTable.PriceColumnName, operationItem.Price);

        operationItem.Id = sqdb.insert(OperationItemTable.TableName, null, cv);
        sqdb.close();
    }

    @Override
    public void Remove(OperationItem item) {

    }

    @Override
    public void Update(OperationItem item) {

    }

    @Override
    public ArrayList<OperationItem> GetAll() {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        Cursor cursor = sqdb.query(OperationItemTable.TableName, new String[] {
                        _operationItemTable.IdColumnName,
                        _operationItemTable.OperationIdColumnName,
                        _operationItemTable.ProductIdColumnName,
                        _operationItemTable.CountOfProductsName,
                        _operationItemTable.PriceColumnName},
                null, // The columns for the WHERE clause
                null, // The values for the WHERE clause
                null, // don't group the rows
                null, // don't filter by row groups
                null // The sort order
        );
        ArrayList<OperationItem> result = new ArrayList<OperationItem>();
        while (cursor.moveToNext()) {
            // GET COLUMN INDICES + VALUES OF THOSE COLUMNS
            int id = cursor.getInt(cursor
                    .getColumnIndex(_operationItemTable.IdColumnName));

            int operationId = cursor.getInt(cursor
                    .getColumnIndex(_operationItemTable.OperationIdColumnName));

            int productId = cursor.getInt(cursor
                    .getColumnIndex(_operationItemTable.ProductIdColumnName));

            double price = cursor.getDouble(cursor.getColumnIndex(_operationItemTable.PriceColumnName));

            int count = cursor.getInt(cursor.getColumnIndex(_operationItemTable.CountOfProductsName));


            Log.i("LOG_TAG",
                    "ROW " + id +
                    " OperationId " + operationId +
                    " ProductId " + productId +
                    " Price " + price +
                    " Count " + count);
            OperationItem operationItem = new OperationItem();
            operationItem.Id = id;
            operationItem.OperationId =operationId;
            operationItem.ProductId = productId;
            operationItem.Price = price;
            operationItem.Count = count;
            result.add(operationItem);
        }
        cursor.close();
        return result;
    }
}
