package com.simplegames.finance.dal.address;

import com.simplegames.finance.dal.TableParams;

/**
 * Created by andrey.kakin on 20.10.2014.
 */
public class AddressTable extends TableParams {
    public static String TableName = "Address";
    public static String IdColumnName = "_id";
    public static String CityColumn = "City";
    public static String StreetColumn = "Street";
    public static String NumberOfHouseColumn = "NumberOfHouse";

    @Override
    public String GetSqlCreate() {
        return "CREATE TABLE "  + AddressTable.TableName + " (" +
                IdColumnName            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CityColumn              + " VARCHAR(64), " +
                NumberOfHouseColumn     + " INTEGER, " +
                StreetColumn            + " VARCHAR(128));";

    }

    @Override
    public String GetSqlDelete() {
        return "DROP TABLE IF EXISTS " + TableName;
    }
}
