package com.simplegames.finance.dal.operation;

import com.simplegames.finance.dal.Common.TableParams;

/**
 * Created by andrey.kakin on 13.10.2014.
 */
public class OperationTable extends TableParams {

    public static String IdColumnName = "_id";
    public static String NameColumnName = "Name";
    public static String DateTimeColumnName = "Date";
    public static String CurrencyColumnName = "Currency";

    public static String TableName = "Operation";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE "  + OperationTable.TableName + " (" +
        IdColumnName            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        NameColumnName          + " VARCHAR(255), " +
        DateTimeColumnName      + " DATETIME, " +
        CurrencyColumnName      + " VARCHAR(3));";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName;
    }
}

