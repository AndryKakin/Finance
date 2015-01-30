package com.simplegames.finance.dal.Category;

import com.simplegames.finance.dal.Common.TableParams;

/**
 * Created by andrey.kakin on 30.01.2015.
 */
public class CategoryTable extends TableParams{

    public static String IdColumnName = "_id";
    public String CategoryToCategoryColumnName = "ParentCategoryId";
    public String NameColumnName = "Name";
    public String DescriptionColumnName = "Description";

    public static String TableName = "CategoryOfProduct";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE " + TableName + " (" +
                IdColumnName                    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoryToCategoryColumnName    + " INTEGER, " +
                NameColumnName                  + " VARCHAR(255), " +
                DescriptionColumnName           + " VARCHAR(2048)); ";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName;
    }
}
