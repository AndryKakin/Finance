package com.simplegames.finance.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.simplegames.finance.models.Product;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class FinanceDataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "finance_database.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES = ProductTable.SQL_CREATE;
    private static final String SQL_DELETE_ENTRIES = ProductTable.SQL_DELETE;

        public FinanceDataBase(Context context) {
            // TODO Auto-generated constructor stub
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            Log.w("LOG_TAG", "Обновление базы данных с версии " + oldVersion
                    + " до версии " + newVersion + ", которое удалит все старые данные");
            // Удаляем предыдущую таблицу при апгрейде
            db.execSQL(SQL_DELETE_ENTRIES);
            // Создаём новый экземпляр таблицы
            onCreate(db);
        }
    }