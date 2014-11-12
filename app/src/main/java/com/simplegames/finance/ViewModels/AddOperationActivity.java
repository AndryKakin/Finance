package com.simplegames.finance.ViewModels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
        ListView purchaseItemsView = (ListView)findViewById(R.id.purchaseItemsView);
        purchaseItemsView.setAdapter(new MyAdapter());
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

    private class MyAdapter extends BaseAdapter {

        private ArrayList<Product> _data;
        public MyAdapter()
        {
            _data  = new ArrayList<Product>();
            Product product1 = new Product();
            product1.Name = "Test";
            product1.Id = 34;
            _data.add(product1);

            Product product2 = new Product();
            product2.Name = "sdfs";
            product2.Id = 3223;
            _data.add(product2);
        }

        @Override
        public int getCount() {
            return _data.size();
        }

        @Override
        public Product getItem(int position) {
            return _data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return _data.get(position).hashCode();
    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.operation_items_template, parent, false);
            }
            ((TextView) convertView.findViewById(R.id.productNameView))
                    .setText(getItem(position).Name);

            ((EditText) convertView.findViewById(R.id.editProductCostView))
                    .setText(Integer.toString(getItem(position).Id));
            return convertView;
        }
    }
}
