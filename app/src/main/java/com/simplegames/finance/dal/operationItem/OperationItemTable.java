package com.simplegames.finance.dal.operationItem;

import com.simplegames.finance.dal.TableParams;
import com.simplegames.finance.dal.operation.OperationTable;
import com.simplegames.finance.dal.product.ProductTable;

/**
 * Created by andrey.kakin on 16.10.2014.
 */
public class OperationItemTable extends TableParams {

    public String ProductInOperationTableName = "ProductItemIn";
    public String PIO_IdColumnName = "_id";
    public String PIO_OperationIdColumnName = "FKOperationId";
    public String PIO_ProductIdColumnName = "FKProductId";
    public String PIO_PriceColumnName = "Price";



    public static String TableName = "Operation";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE "         + ProductInOperationTableName + " (" +
                PIO_IdColumnName        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PIO_OperationIdColumnName   + " INTEGER, " +
                PIO_PriceColumnName         + " DECIMAL, " +
                CreateForeignKey(PIO_OperationIdColumnName, OperationTable.TableName, OperationTable.IdColumnName) +
                CreateForeignKey(PIO_ProductIdColumnName, ProductTable.TableName, ProductTable.IdColumnName)
                + ");";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName + " \n " +
                "DROP TABLE IF EXISTS " + ProductInOperationTableName;
    }
}
