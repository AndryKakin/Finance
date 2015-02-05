package com.simplegames.finance.ViewModels.Products;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simplegames.finance.BL.Managers.Operations.OperationManager;
import com.simplegames.finance.BL.Managers.Products.ProductManager;
import com.simplegames.finance.BL.Model.Operation;
import com.simplegames.finance.BL.Model.Product;

import com.simplegames.finance.ViewModels.Common.BusyActionBarActivity;
import com.simplegames.finance.app.R;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class ShowAllProductsActivity extends BusyActionBarActivity {
    private ProductManager _productManager;

    private LoadAllProducts _loadAllProducts;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity_show_all_products);
		_loadAllProducts = new LoadAllProducts();
		_loadAllProducts.execute();
    }

    private void initializeProductAdapter(ArrayList<com.simplegames.finance.BL.Model.Product> result)
    {
		ArrayList<String> products = new ArrayList<String>();
		for (int i=0; i < result.size(); i++)
        {
            products.add(result.get(i).Name);
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, products);
        ListView listOfProducts = (ListView)findViewById(R.id.listProductsView);
        listOfProducts.setAdapter(adapter);
        progress.hide();
    }
	
    private class LoadAllProducts extends AsyncTask<Void, Integer, ArrayList<Product>>
    {
        protected void onPreExecute (){
            Log.d("PreExecute", "On pre Execute......");
            progress.setMessage("Data is loading...");
            progress.show();
        }

        protected ArrayList<com.simplegames.finance.BL.Model.Product> doInBackground(Void...arg0) {
            Log.d("DoINBackGround","On doInBackground...");
            _productManager = new ProductManager(getApplicationContext());
            return  _productManager.GetAll();
        }

        protected void onProgressUpdate(Integer...a){
            Log.d("onProgressUpdate","You are in progress update ... ");
        }

        protected void onPostExecute(ArrayList<com.simplegames.finance.BL.Model.Product> result) {
            initializeProductAdapter(result);
        }
    }
}
