package com.simplegames.finance.ViewModels.Operations;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.simplegames.finance.BL.Managers.Products.ProductManager;
import com.simplegames.finance.BL.Managers.Operations.OperationManager;
import com.simplegames.finance.BL.Model.Operation;
import com.simplegames.finance.BL.Model.OperationItem;
import com.simplegames.finance.BL.Model.Product;
import com.simplegames.finance.ViewModels.Common.BusyActionBarActivity;
import com.simplegames.finance.ViewModels.Operations.Adapters.ProductsAdapter;
import com.simplegames.finance.ViewModels.Operations.Adapters.PurchasesAdapter;
import com.simplegames.finance.ViewModels.Operations.Models.Converters.ProductVMConverter;
import com.simplegames.finance.ViewModels.Operations.Models.ProductSelectListener;
import com.simplegames.finance.ViewModels.Operations.Models.ProductVM;
import com.simplegames.finance.ViewModels.StartActivity;
import com.simplegames.finance.app.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by andrey.kakin on 29.10.2014.
 */
public class AddOperationActivity extends BusyActionBarActivity {
    private OperationManager _operationManager;
    private ProductManager _productManager;

    private ArrayList<Product> _availableProducts;
    private ArrayList<ProductVM> _productVMs;
    private ArrayList<OperationItem> _purchaseItems;

    private ProductsAdapter _productAdapter;
    private PurchasesAdapter _purchaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progress.setMessage("Data is loading...");
        progress.show();

        setContentView(R.layout.operations_activity_add_operation);
        _operationManager = new OperationManager(this);
        _productManager = new ProductManager(this);
        _availableProducts = _productManager.GetAll();
        _purchaseItems = new ArrayList<OperationItem>();

        ProductSelectListener addNewOperation = new ProductSelectListener() {
            @Override
            public void OnSelected(ProductVM selectedProductVM) {
                progress.setMessage("Item moving...");
                progress.show();
                Product selectedProduct = ProductVMConverter.ConvertVMToBL(selectedProductVM);
                OperationItem operationItem = new OperationItem();
                operationItem.Product = selectedProduct;
                operationItem.Price = 0;
                operationItem.Count = 1;
                _purchaseAdapter.add(operationItem);
                _purchaseAdapter.notifyDataSetChanged();
                _productAdapter.remove(ProductVMConverter.ConvertProductBLToVM(selectedProduct));
                _productAdapter.notifyDataSetChanged();
                progress.hide();
            }
        };

        _productVMs = ProductVMConverter.ConvertProductsBLToVM(_availableProducts);
        for(int i=0; i<_productVMs.size(); i++)
        {
            ProductVM productVM = _productVMs.get(i);
            productVM.addListener(addNewOperation);
        }

        _productAdapter = new ProductsAdapter(this, _productVMs);
        _purchaseAdapter = new PurchasesAdapter(this,_purchaseItems);

        ListView productListView = (ListView)findViewById(R.id.productsListView);
        productListView.setAdapter(_productAdapter);

        ListView purchaseItemsView = (ListView)findViewById(R.id.purchaseItemsView);
        purchaseItemsView.setAdapter(_purchaseAdapter);

        progress.hide();
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
                publishProgress((int) ((i / (float) count) * 100));
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
}
