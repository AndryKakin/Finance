package com.simplegames.finance.dal.operationItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.simplegames.finance.dal.FinanceDataBase;
import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.dal.models.OperationItem;
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
    public void Add(OperationItem item) {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();
        DateFormat dateF = DateFormat.getDateTimeInstance();

        //cv.put(_operationItemTable.DateTimeColumnName, dateF.format(item.DateTime));

        sqdb.insert(OperationTable.TableName, null, cv);
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
        return null;
    }
}
