package com.simplegames.finance.dal.product;

import com.simplegames.finance.dal.ITableParams;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class ProductTable implements ITableParams{

    public String IdColumnName = "_id";
    public String NameColumnName = "Name";
    public String DescriptionColumnName = "Description";

    @Override
    public String GetTableName() {
        return "Product";
    }

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE " + GetTableName() + "(" +
                IdColumnName + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NameColumnName + " VARCHAR(255), " +
                DescriptionColumnName + " VARCHAR(2048));";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + GetTableName();
    }
}
