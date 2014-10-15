package com.simplegames.finance.ViewModels;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simplegames.finance.app.R;
import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.dal.SQLiteDbFabric;
import com.simplegames.finance.models.Product;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class ShowAllProductsActivity extends ActionBarActivity {
    private SQLiteDbFabric _fabric;
    private ArrayList<Product> _products;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_products);
        _fabric = new SQLiteDbFabric();
        _fabric.Context = this;
        IRepository<Product> productRepository = _fabric.GetProductRepository();
        _products = productRepository.GetAll();
        ArrayList<String> products = new ArrayList<String>();
        for (int i=0; i < _products.size(); i++)
        {
            products.add(_products.get(i).Name);
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, products);
        ListView listOfProducts = (ListView)findViewById(R.id.listProductsView);
        listOfProducts.setAdapter(adapter);
    }
}