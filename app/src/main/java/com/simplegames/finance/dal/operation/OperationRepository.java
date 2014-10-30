package com.simplegames.finance.dal.operation;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.simplegames.finance.dal.FinanceDataBase;
import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.dal.models.Operation;

import java.text.DateFormat;
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
    public void Add(Operation item) {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();
        DateFormat dateF = DateFormat.getDateTimeInstance();

        cv.put(_operationTable.DateTimeColumnName, dateF.format(item.DateTime));
        //cv.put(_operationTable.CurrencyColumnName,);
        sqdb.insert(OperationTable.TableName, null, cv);
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
        return null;
    }
}
