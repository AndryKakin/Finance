package com.simplegames.finance.dal.operation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.simplegames.finance.dal.DB.FinanceDataBase;
import com.simplegames.finance.dal.Common.IRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by andrey.kakin on 13.10.2014.
 */
public class OperationRepository implements IRepository<Operation> {
    private FinanceDataBase _financeDataBase;
    private OperationTable _operationTable = new OperationTable();

    public OperationRepository(Context context)
    {
        _financeDataBase = new FinanceDataBase(context);
    }

    @Override
    public void Add(Operation operation) {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();

        cv.put(_operationTable.DateTimeColumnName, dateFormat.format(operation.DateTime));
        cv.put(_operationTable.CurrencyColumnName, operation.Currency);
        cv.put(_operationTable.NameColumnName, operation.Name);
        operation.Id = sqdb.insert(OperationTable.TableName, null, cv);
        sqdb.close();
    }

    @Override
    public void Remove(Operation item) {

    }

    @Override
    public void Update(Operation item) {

    }

    @Override
    public ArrayList<Operation> GetAll() {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        Cursor cursor = sqdb.query(OperationTable.TableName, new String[] {
                        _operationTable.IdColumnName,
                        _operationTable.NameColumnName,
                        _operationTable.DateTimeColumnName,
                        _operationTable.CurrencyColumnName},
                null, // The columns for the WHERE clause
                null, // The values for the WHERE clause
                null, // don't group the rows
                null, // don't filter by row groups
                null // The sort order
        );
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        ArrayList<Operation> result = new ArrayList<Operation>();
        while (cursor.moveToNext()) {
            // GET COLUMN INDICES + VALUES OF THOSE COLUMNS
            int id = cursor.getInt(cursor
                    .getColumnIndex(_operationTable.IdColumnName));

            String name = cursor.getString(cursor
                    .getColumnIndex(_operationTable.NameColumnName));

            String dateTime = cursor.getString(cursor
                    .getColumnIndex(_operationTable.DateTimeColumnName));

            String currency = cursor.getString(cursor
                    .getColumnIndex(_operationTable.CurrencyColumnName));
            Log.i("LOG_TAG", "ROW " + id + " NAME " + name +
                    " DateTime " + dateTime +
                    " Currency " + currency);
            Operation operation = new Operation();
            operation.Id = id;
            operation.Name = name;
            try {
                operation.DateTime = dateFormat.parse(dateTime);
            } catch (ParseException e) {
                Log.e("Operation Repository",e.toString());
            }
            operation.Currency = currency;
            result.add(operation);
        }
        cursor.close();
        return result;
    }
}
