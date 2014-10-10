package com.simplegames.finance.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.simplegames.finance.dal.product.ProductTable;
import com.simplegames.finance.dal.shop.ShopTable;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class FinanceDataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "finance_database.db";
    private static final int DATABASE_VERSION = 1;

    private ArrayList<ITableParams> _tables = new ArrayList<ITableParams>();

        public FinanceDataBase(Context context) {
            // TODO Auto-generated constructor stub
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            _tables.add(new ProductTable());
            _tables.add(new ShopTable());
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sqlCreates = "";
            for(int i=0; i < _tables.size(); i++) {
                ITableParams table = _tables.get(i);
                sqlCreates += table.GetSqlCreate() + " \n ";
            }
            db.execSQL(sqlCreates);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            Log.w("LOG_TAG", "Update database from  " + oldVersion
                    + " to version " + newVersion + ".");
            String sqlDeletes = "";
            for(int i=0; i < _tables.size(); i++) {
                ITableParams table = _tables.get(i);
                sqlDeletes += table.GetSqlDelete() + " \n ";
            }
            db.execSQL(sqlDeletes);

            onCreate(db);
        }
    }