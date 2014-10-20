package com.simplegames.finance.dal.operation;

import com.simplegames.finance.dal.TableParams;
import com.simplegames.finance.dal.product.ProductTable;

/**
 * Created by andrey.kakin on 13.10.2014.
 */
public class OperationTable extends TableParams {

    public static String IdColumnName = "_id";
    public String DateTimeColumnName = "Date";
    public String CurrencyColumnName = "Currency";

    public static String TableName = "Operation";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE "  + OperationTable.TableName + " (" +
        IdColumnName            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        DateTimeColumnName      + " DATETIME, " +
        CurrencyColumnName      + " VARCHAR(3));";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName;
    }
}

