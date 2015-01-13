package com.simplegames.finance.dal.product;

import com.simplegames.finance.dal.Common.TableParams;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class ProductTable extends TableParams {

    public static String IdColumnName = "_id";
    public String NameColumnName = "Name";
    public String DescriptionColumnName = "Description";
    public String Image = "Image";

    public static String TableName = "Product";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE " + TableName + " (" +
                IdColumnName + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NameColumnName + " VARCHAR(255), " +
                Image + " BLOB, " +
                DescriptionColumnName + " VARCHAR(2048)); ";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName;
    }
}
