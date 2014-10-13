package com.simplegames.finance.dal.operation;

import com.simplegames.finance.dal.ITableParams;

/**
 * Created by andrey.kakin on 13.10.2014.
 */
public class OperationTable implements ITableParams{
    @Override
    public String GetTableName() {
        return null;
    }

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE [operationItems] (\n" +
                "  [_id] INT CONSTRAINT [ProductToOperation] REFERENCES [Product]([_id]), \n" +
                "  [productID] INT);";
    }

    @Override
    public String GetSqlDelete() {
        return null;
    }
}
