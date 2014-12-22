package com.simplegames.finance.ViewModels.Operations;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.simplegames.finance.BL.Managers.Products.ProductManager;
import com.simplegames.finance.BL.Managers.Operations.OperationManager;
import com.simplegames.finance.BL.Model.Operation;
import com.simplegames.finance.BL.Model.OperationItem;
import com.simplegames.finance.BL.Model.Product;
import com.simplegames.finance.ViewModels.StartActivity;
import com.simplegames.finance.app.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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

        productListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        purchaseItemsView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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

    public void addNewOperation_OnClick(View view) {
        com.simplegames.finance.BL.Model.Operation operation = new com.simplegames.finance.BL.Model.Operation();
        operation.Currency = "RUB";
        Calendar cal = Calendar.getInstance();
        operation.DateTime = cal.getTime();
        for(int i=0; i < _purchaseAdapter.getCount(); i++)
        {
            operation.Items.add(_purchaseAdapter.getItem(i));
        }
        AddNewOperationUITask addNewOperationUITask = new AddNewOperationUITask();
        addNewOperationUITask.execute(operation);
    }

    private class AddNewOperationUITask extends AsyncTask<com.simplegames.finance.BL.Model.Operation, Integer, Void> {
        @Override
        protected Void doInBackground(Operation... params) {
            int count = 5;
            for(int i=0;i<count;i++) {
                try {
                    Thread.sleep(1000);
                    publishProgress((int) ((i / (float) count) * 100));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            _operationManager.AddOperation(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Intent intent = new Intent(AddOperationActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

        }

    }

    public void cancel_onClick(View view) {
        Intent intent = new Intent(AddOperationActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public void addProductToOperation_OnClick(View view) {
        //if(_productAdapter. != null) {
        //    Product selected = _productAdapter.SelectedItem;
        //    OperationItem operationItem = new OperationItem();
        //    operationItem.Product = selected;
        //   operationItem.Price = 0;
        //    _purchaseAdapter.Add(operationItem);
        //}

    }
}
