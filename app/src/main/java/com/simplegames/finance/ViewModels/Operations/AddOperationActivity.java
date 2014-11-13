package com.simplegames.finance.ViewModels.Operations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.simplegames.finance.BL.Managers.ProductManager;
import com.simplegames.finance.BL.Model.Operation;
import com.simplegames.finance.BL.Managers.OperationManager;
import com.simplegames.finance.BL.Model.Product;
import com.simplegames.finance.ViewModels.StartActivity;
import com.simplegames.finance.app.R;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 29.10.2014.
 */
public class AddOperationActivity extends ActionBarActivity {
    private OperationManager _operationManager;
    private ProductManager _productManager;
    private ArrayList<Product> _availableProducts;
    private ProductsAdapter _productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_operation);
        _operationManager = new OperationManager(this);
        _productManager = new ProductManager(this);
        _availableProducts = _productManager.GetAll();
        _productAdapter = new ProductsAdapter(this,_availableProducts);
        ListView purchaseItemsView = (ListView)findViewById(R.id.purchaseItemsView);
        purchaseItemsView.setAdapter(_productAdapter);
    }

    public void cancel_onClick(View view) {
        Intent intent = new Intent(AddOperationActivity.this, StartActivity.class);
        startActivity(intent);
    }
}
