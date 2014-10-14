package com.simplegames.finance.dal.shop;

import com.simplegames.finance.dal.ITableParams;

/**
 * Created by andrey.kakin on 10.10.2014.
 */
public class ShopTable implements ITableParams {
    public String IdColumnName = "_id";
    public String NameColumnName = "Name";
    public String CityColumnName = "City";
    public String StreetColumnName = "Street";
    public String NumberOfHouseColumnName = "NumberOfStreet";
    public String DescriptionColumnName = "Description";

    @Override
    public String GetTableName() {
        return "Shop";
    }

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE " + GetTableName() + " (" +
                IdColumnName            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NameColumnName          + " VARCHAR(255), " +
                CityColumnName          + " VARCHAR(255), " +
                StreetColumnName        + " VARCHAR(255), " +
                DescriptionColumnName   + " VARCHAR(2048), " +
                NumberOfHouseColumnName + " INTEGER);";
    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + GetTableName();
    }
}
