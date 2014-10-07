package com.simplegames.finance.dal;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class ProductTable {
    public static String TableName = "Product";

    public static String IdColumnName = "_id";
    public static String NameColumnName = "Name";
    public static String DescriptionColumnName = "Description";


    public static String SQL_CREATE = "CREATE TABLE " + TableName +
            "(" + IdColumnName + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NameColumnName + " VARCHAR(255), " +
            DescriptionColumnName + "VARCHAR(2048));";

    public static String SQL_DELETE = "DROP TABLE IF EXISTS " + TableName;
}
