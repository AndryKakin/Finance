package com.simplegames.finance.ViewModels.Products;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.simplegames.finance.ViewModels.StartActivity;
import com.simplegames.finance.app.R;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.DB.SQLiteDbFabric;
import com.simplegames.finance.dal.product.Product;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class AddProductActivity extends ActionBarActivity {
    private SQLiteDbFabric _fabric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity_add_product);
        _fabric = new SQLiteDbFabric();
        _fabric.Context = this;
    }

    public void addNewProduct_onClick(View view) {
        EditText nameEditText = (EditText)findViewById(R.id.add_product_editProductName);
        EditText descriptionEditText = (EditText)findViewById(R.id.add_product_editProductDescription);
        IRepository<Product> productRepository = _fabric.GetProductRepository();
        Product product = new Product();
        product.Name = nameEditText.getText().toString();
        product.Description = descriptionEditText.getText().toString();
        productRepository.Add(product);

        Intent intent = new Intent(AddProductActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public void cancel_onClick(View view) {
        Intent intent = new Intent(AddProductActivity.this, StartActivity.class);
        startActivity(intent);
    }
}