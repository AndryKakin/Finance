package com.simplegames.finance.dal.shop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.simplegames.finance.dal.FinanceDataBase;
import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.models.Product;
import com.simplegames.finance.models.Shop;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 10.10.2014.
 */
public class ShopRepository implements IRepository<Shop> {
    private FinanceDataBase _financeDataBase;
    private ShopTable _shopTable = new ShopTable();

    public ShopRepository(Context context)
    {
        _financeDataBase = new FinanceDataBase(context);
    }

    @Override
    public void Add(Shop item) {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(_shopTable.NameColumnName, item.Name);
        cv.put(_shopTable.CityColumnName, item.City);
        cv.put(_shopTable.StreetColumnName, item.Street);
        cv.put(_shopTable.NumberOfHouseColumnName, item.NumberOfHouse);
        sqdb.insert(ShopTable.TableName, null, cv);
        sqdb.close();
    }

    @Override
    public void Remove(Shop item) {

    }

    @Override
    public void Update(Shop item) {

    }

    @Override
    public ArrayList<Shop> GetAll() {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        Cursor cursor = sqdb.query(ShopTable.TableName, new String[] {
                        _shopTable.IdColumnName,
                        _shopTable.NameColumnName,
                        _shopTable.CityColumnName,
                        _shopTable.StreetColumnName,
                        _shopTable.NumberOfHouseColumnName},
                null, // The columns for the WHERE clause
                null, // The values for the WHERE clause
                null, // don't group the rows
                null, // don't filter by row groups
                null // The sort order
        );
        ArrayList<Shop> result = new ArrayList<Shop>();
        while (cursor.moveToNext()) {
            // GET COLUMN INDICES + VALUES OF THOSE COLUMNS
            int id = cursor.getInt(cursor
                    .getColumnIndex(_shopTable.IdColumnName));

            String name = cursor.getString(cursor
                    .getColumnIndex(_shopTable.NameColumnName));

            String city = cursor.getString(cursor
                    .getColumnIndex(_shopTable.CityColumnName));

            String street = cursor.getString(cursor
                    .getColumnIndex(_shopTable.StreetColumnName));

            int number = cursor.getInt(cursor
                    .getColumnIndex(_shopTable.NumberOfHouseColumnName));

            //Log.i("LOG_TAG", "ROW " + id + " NAME " + name + " DESCRIPTION " + description);
            Shop shop = new Shop();
            shop.Id = id;
            shop.Name = name;
            shop.City = city;
            shop.Street = street;
            shop.NumberOfHouse = number;
            result.add(shop);
        }
        cursor.close();
        return result;
    }
}
