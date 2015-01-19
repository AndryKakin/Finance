package com.simplegames.finance.dal.operationItem;

import com.simplegames.finance.dal.Common.TableParams;
import com.simplegames.finance.dal.operation.OperationTable;
import com.simplegames.finance.dal.product.ProductTable;

/**
 * Created by andrey.kakin on 16.10.2014.
 */
public class OperationItemTable extends TableParams {
    public String IdColumnName = "_id";
    public String OperationIdColumnName = "FKOperationId";
    public String ProductIdColumnName = "FKProductId";
    public String PriceColumnName = "Price";
    public String CountOfProductsName = "Count";



    public static String TableName = "OperationItems";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE "         + TableName + " (" +
                IdColumnName        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                OperationIdColumnName   + " INTEGER, " +
                ProductIdColumnName     + " INTEGER, " +
                CountOfProductsName     + " INTEGER, " +
                PriceColumnName         + " DOUBLE,  " +
                CreateForeignKey(OperationIdColumnName, OperationTable.TableName, OperationTable.IdColumnName) +
                CreateForeignKey(ProductIdColumnName, ProductTable.TableName, ProductTable.IdColumnName) +
                "); ";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName;
    }
}
