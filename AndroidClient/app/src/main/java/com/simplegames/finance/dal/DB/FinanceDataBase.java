package com.simplegames.finance.dal.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.simplegames.finance.dal.Category.CategoryTable;
import com.simplegames.finance.dal.Common.TableParams;
import com.simplegames.finance.dal.Composition.CompositionTable;
import com.simplegames.finance.dal.Composition.CompositionToProductTable;
import com.simplegames.finance.dal.operation.OperationTable;
import com.simplegames.finance.dal.operationItem.OperationItemTable;
import com.simplegames.finance.dal.product.ProductTable;
import com.simplegames.finance.dal.shop.ShopTable;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class FinanceDataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "finance_database.db";
    private static final int DATABASE_VERSION = 1;

    private ArrayList<TableParams> _tables = new ArrayList<TableParams>();

        public FinanceDataBase(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            _tables.add(new ProductTable());
            _tables.add(new ShopTable());
            _tables.add(new OperationTable());
            _tables.add(new OperationItemTable());
            _tables.add(new CategoryTable());
            _tables.add(new CompositionTable());
            _tables.add(new CompositionToProductTable());
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            for(int i=0; i < _tables.size(); i++) {
                String execute = _tables.get(i).GetSqlCreate();
                db.execSQL(execute);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("LOG_TAG", "Update database from  " + oldVersion
                    + " to version " + newVersion + ".");
            String sqlDeletes = "";
            for(int i=0; i < _tables.size(); i++) {
                TableParams table = _tables.get(i);
                sqlDeletes += table.GetSqlDelete() + " \n ";
            }
            db.execSQL(sqlDeletes);

            onCreate(db);
        }
    }