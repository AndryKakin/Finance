package com.simplegames.finance.ViewModels.Operations;

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
import com.simplegames.finance.ViewModels.Operations.Adapters.ProductsAdapter;
import com.simplegames.finance.ViewModels.Operations.Adapters.PurchasesAdapter;
import com.simplegames.finance.ViewModels.Operations.Models.ProductVM;
import com.simplegames.finance.ViewModels.StartActivity;
import com.simplegames.finance.app.R;

import java.util.ArrayList;
import java.util.Calendar;

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

        _productAdapter = new ProductsAdapter(this, ConvertProductsBLToVM(_availableProducts));
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

    private ArrayList<ProductVM> ConvertProductsBLToVM(ArrayList<Product> blProducts) {
        ArrayList<ProductVM> result = new ArrayList<ProductVM>();
        for(int i=0; i<blProducts.size(); i++)
        {
            result.add(ConvertProductBLToVM(blProducts.get(i)));
        }
        return result;
    }

    private ProductVM ConvertProductBLToVM(Product product) {
        ProductVM productVM = new ProductVM();
        productVM.Bitmap = product.Bitmap;
        productVM.Description = product.Description;
        productVM.Id = product.Id;
        productVM.Name =  product.Name;
        return productVM;
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
        ArrayList<Product> selectedProducts = new ArrayList<Product>();
        for(int i=0; i < _productAdapter.getCount(); i++)
        {
            ProductVM product =_productAdapter.getItem(i);
            if(product.IsSelected)
            {
                selectedProducts.add(ConvertVMToBL(product));
            }
        }
        if(selectedProducts.size() > 0)
        {
            for(int i=0; i < selectedProducts.size(); i++)
            {
                Product selectedProduct = selectedProducts.get(i);
                OperationItem operationItem = new OperationItem();
                operationItem.Product = selectedProduct;
                operationItem.Price = 0;
                operationItem.Count = 1;
                _purchaseAdapter.add(operationItem);
                _productAdapter.remove(ConvertProductBLToVM(selectedProduct));
            }
        }
    }

    private Product ConvertVMToBL(ProductVM productVM) {
        Product product = new Product();
        product.Bitmap = productVM.Bitmap;
        product.Description = productVM.Description;
        product.Id = productVM.Id;
        product.Name =  productVM.Name;
        return product;
    }
}
