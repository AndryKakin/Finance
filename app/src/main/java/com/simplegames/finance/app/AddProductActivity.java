package com.simplegames.finance.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.dal.SQLiteDbFabric;
import com.simplegames.finance.models.Product;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class AddProductActivity extends ActionBarActivity {
    private SQLiteDbFabric _fabric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        _fabric = new SQLiteDbFabric();
        _fabric.Context = this;
    }

    public void addNewProduct_onClick(View view) {
        IRepository<Product> productRepository = _fabric.GetProductRepository();
        Product product = new Product();
        product.Name = "";
        product.Description = "";
        productRepository.Add(product);
    }
}