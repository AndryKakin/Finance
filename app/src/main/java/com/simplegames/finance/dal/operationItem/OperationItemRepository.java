package com.simplegames.finance.dal.operationItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.simplegames.finance.dal.DB.FinanceDataBase;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.operation.Operation;
import com.simplegames.finance.dal.operation.OperationTable;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
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
        try {
            SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(_operationItemTable.OperationIdColumnName, operationItem.OperationId);
            cv.put(_operationItemTable.ProductIdColumnName, operationItem.ProductId);
            cv.put(_operationItemTable.PriceColumnName,
                    DecimalFormat.getNumberInstance().format(operationItem.Price));

            operationItem.Id = sqdb.insert(OperationTable.TableName, null, cv);
            sqdb.close();
        }
        catch (Exception ex) {

        }
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
        Cursor cursor = sqdb.query(OperationTable.TableName, new String[] {
                        _operationItemTable.IdColumnName,
                        _operationItemTable.OperationIdColumnName,
                        _operationItemTable.ProductIdColumnName,
                        _operationItemTable.PriceColumnName},
                null, // The columns for the WHERE clause
                null, // The values for the WHERE clause
                null, // don't group the rows
                null, // don't filter by row groups
                null // The sort order
        );
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        ArrayList<OperationItem> result = new ArrayList<OperationItem>();
        while (cursor.moveToNext()) {
            // GET COLUMN INDICES + VALUES OF THOSE COLUMNS
            int id = cursor.getInt(cursor
                    .getColumnIndex(_operationItemTable.IdColumnName));

            int operationId = cursor.getInt(cursor
                    .getColumnIndex(_operationItemTable.OperationIdColumnName));

            int productId = cursor.getInt(cursor
                    .getColumnIndex(_operationItemTable.ProductIdColumnName));

            String price = cursor.getString(cursor
                    .getColumnIndex(_operationItemTable.PriceColumnName));


            Log.i("LOG_TAG", "ROW " + id + " OperationId " + operationId +
                    " ProductId " + productId +
                    " Price " + price);
            OperationItem operationItem = new OperationItem();
            operationItem.Id = id;
            operationItem.OperationId =operationId;
            operationItem.ProductId = productId;
            try {
                operationItem.Price = BigDecimal.valueOf((Double) DecimalFormat.getInstance().parse(price));
            } catch (ParseException e) {
                Log.e("OperationItem Repository", e.toString());
            }
            result.add(operationItem);
        }
        cursor.close();
        return result;
    }
}
