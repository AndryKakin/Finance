package com.simplegames.finance.dal.operation;

import com.simplegames.finance.dal.ITableParams;
import com.simplegames.finance.dal.product.ProductTable;

/**
 * Created by andrey.kakin on 13.10.2014.
 */
public class OperationTable implements ITableParams{

    public String IdColumnName = "_id";
    public String DateTimeColumnName = "Date";
    public String CurrencyColumnName = "Currency";

    public String ProductInOperationTableName = "ProductItemIn";
    public String PIO_IdColumnName = "_id";
    public String PIO_OperationIdColumnName = "FKOperationId";
    public String PIO_ProductIdColumnName = "FKProductId";
    public String PIO_PriceColumnName = "Price";



    public static String TableName = "Operation";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE "  + OperationTable.TableName + " (" +
        IdColumnName            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        DateTimeColumnName      + " DATETIME, " +
        CurrencyColumnName      + " VARCHAR(3)); \n" +
        "CREATE TABLE "         + ProductInOperationTableName + " (" +
        PIO_IdColumnName        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        PIO_OperationIdColumnName   + " INTEGER, " +
        PIO_PriceColumnName         + " DECIMAL, " +
        CreateForeignKey(PIO_OperationIdColumnName, OperationTable.TableName, IdColumnName) +
        CreateForeignKey(PIO_ProductIdColumnName, ProductTable.TableName, IdColumnName)
                + ");";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName + " \n " +
                "DROP TABLE IF EXISTS " + ProductInOperationTableName;
    }
}

