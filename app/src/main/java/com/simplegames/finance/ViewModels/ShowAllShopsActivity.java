package com.simplegames.finance.ViewModels;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simplegames.finance.app.R;
import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.dal.SQLiteDbFabric;
import com.simplegames.finance.dal.models.Shop;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 13.10.2014.
 */
public class ShowAllShopsActivity extends ActionBarActivity {
    private SQLiteDbFabric _fabric;
    private ArrayList<Shop> _shops;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_shops);
        _fabric = new SQLiteDbFabric();
        _fabric.Context = this;

        IRepository<Shop> shopRepository = _fabric.GetShopRepository();
        _shops = shopRepository.GetAll();
        ArrayList<String> shops = new ArrayList<String>();
        for (int i=0; i < _shops.size(); i++)
        {
            shops.add(_shops.get(i).Name);
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, shops);
        ListView listOfProducts = (ListView)findViewById(R.id.listShopsView);
        listOfProducts.setAdapter(adapter);
    }
}
