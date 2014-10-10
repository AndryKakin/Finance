package com.simplegames.finance.dal;

/**
 * Created by andrey.kakin on 10.10.2014.
 */
public interface ITableParams {
    public String GetTableName();
    public String GetSqlCreate();
    public String GetSqlDelete();
}
