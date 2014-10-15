package com.simplegames.finance.dal;

/**
 * Created by andrey.kakin on 10.10.2014.
 */
public abstract class TableParams {
    public abstract String GetSqlCreate();
    public abstract String GetSqlDelete();

    protected static String CreateForeignKey(String fromColumn,
                                           String toTable,
                                           String toColumn)
    {
        return "  FOREIGN KEY (" + fromColumn + ")" +
                "REFERENCES " + toTable + "(" + toColumn + ")";
    }
}
