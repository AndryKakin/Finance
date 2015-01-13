package com.simplegames.finance.ViewModels.Products;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simplegames.finance.BL.Managers.Products.ProductManager;
import com.simplegames.finance.BL.Model.Product;

import com.simplegames.finance.app.R;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class ShowAllProductsActivity extends ActionBarActivity {
    private ProductManager _productManager;

    private ArrayList<Product> _products;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity_show_all_products);
        _productManager = new ProductManager(this);
        _products = _productManager.GetAll();
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