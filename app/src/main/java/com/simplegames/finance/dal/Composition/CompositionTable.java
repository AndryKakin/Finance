package com.simplegames.finance.dal.Composition;

import com.simplegames.finance.dal.Common.TableParams;

/**
 * Created by andrey.kakin on 30.01.2015.
 */
public class CompositionTable extends TableParams {
    public String IdColumnName = "_id";
    public String NameColumnName = "Name";
    public String DescriptionProductsName = "Description";



    public static String TableName = "Compositions";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE "              + TableName + " (" +
                IdColumnName                + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NameColumnName              + " INTEGER, " +
                DescriptionProductsName     + " DOUBLE  " +
                "); ";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName;
    }
}