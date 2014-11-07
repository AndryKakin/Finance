package com.simplegames.finance.ViewModels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.simplegames.finance.BL.Managers.ProductManager;
import com.simplegames.finance.BL.Model.Operation;
import com.simplegames.finance.BL.Managers.OperationManager;
import com.simplegames.finance.BL.Model.Product;
import com.simplegames.finance.app.R;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 29.10.2014.
 */
public class AddOperationActivity extends ActionBarActivity {
    private OperationManager _operationManager;
    private ProductManager _productManager;
    private ArrayList<Product> _availableProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_operation);
        _operationManager = new OperationManager(this);
        _productManager = new ProductManager(this);
        _availableProducts = _productManager.GetAll();
    }

    public void addNewOperation_onClick(View view) {
        //EditText nameEditText = (EditText)findViewById(R.id.add_product_editProductName);
        //EditText descriptionEditText = (EditText)findViewById(R.id.add_product_editProductDescription);
        //IRepository<Operation> operationIRepository = _fabric.GetOperationRepository();
        //Product product = new Product();
        //product.Name = nameEditText.getText().toString();
        //product.Description = descriptionEditText.getText().toString();
        //productRepository.Add(product);
        Operation operation = new Operation();
        _operationManager.AddOperation(operation);
        Intent intent = new Intent(AddOperationActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public void cancel_onClick(View view) {
        Intent intent = new Intent(AddOperationActivity.this, StartActivity.class);
        startActivity(intent);
    }
}
