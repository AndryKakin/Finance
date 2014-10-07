package com.simplegames.finance.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.dal.SQLiteDbFabric;
import com.simplegames.finance.models.Product;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class DisplayProductsActivity extends ActionBarActivity {
    private SQLiteDbFabric _fabric;
    private ArrayList<Product> _products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        _fabric = new SQLiteDbFabric();
        _fabric.Context = this;
        IRepository<Product> productRepository = _fabric.GetProductRepository();
        _products = productRepository.GetAll();
    }
}