package com.simplegames.finance.ViewModels.Operations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.simplegames.finance.BL.Managers.ProductManager;
import com.simplegames.finance.BL.Managers.OperationManager;
import com.simplegames.finance.BL.Model.OperationItem;
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
    private ArrayList<OperationItem> _purchaseItems;

    private ProductsAdapter _productAdapter;
    private PurchasesAdapter _purchaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operations_activity_add_operation);
        _operationManager = new OperationManager(this);
        _productManager = new ProductManager(this);
        _availableProducts = _productManager.GetAll();
        _purchaseItems = new ArrayList<OperationItem>();

        _productAdapter = new ProductsAdapter(this,_availableProducts);
        _purchaseAdapter = new PurchasesAdapter(this,_purchaseItems);

        ListView productListView = (ListView)findViewById(R.id.productsListView);
        productListView.setAdapter(_productAdapter);

        ListView purchaseItemsView = (ListView)findViewById(R.id.purchaseItemsView);
        purchaseItemsView.setAdapter(_purchaseAdapter);
    }

    public void addNewOperation_OnClick(View view) {
        Intent intent = new Intent(AddOperationActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public void cancel_onClick(View view) {
        Intent intent = new Intent(AddOperationActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public void addProductToOperation_OnClick(View view) {
        ListView productsView = (ListView)view.findViewById(R.id.productsListView);
        ListView purchasesView = (ListView)view.findViewById(R.id.purchaseItemsView);
        productsView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        purchasesView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
}
