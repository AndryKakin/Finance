package com.simplegames.finance.BL.Managers;

import android.content.Context;

import com.simplegames.finance.dal.DB.SQLiteDbFabric;

/**
 * Created by andrey.kakin on 31.10.2014.
 */
public class BaseDBManager {
    protected SQLiteDbFabric _fabric;
    public BaseDBManager(Context context)
    {
        _fabric = new SQLiteDbFabric();
        _fabric.Context = context;
    }
}
