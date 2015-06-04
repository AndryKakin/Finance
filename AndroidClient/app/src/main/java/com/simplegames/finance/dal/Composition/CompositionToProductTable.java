package com.simplegames.finance.dal.Composition;

import com.simplegames.finance.dal.Common.TableParams;

/**
 * Created by andrey.kakin on 30.01.2015.
 */
public class CompositionToProductTable extends TableParams {
    public String IdColumnName = "_id";
    public String CompositionIdColumnName = "FKCompositionId";
    public String ProductIdColumnName = "FKProductId";



    public static String TableName = "CompositionToProduct";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE "              + TableName + " (" +
                IdColumnName                + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CompositionIdColumnName     + " INTEGER, " +
                ProductIdColumnName         + " INTEGER  " +
                "); ";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName;
    }
}