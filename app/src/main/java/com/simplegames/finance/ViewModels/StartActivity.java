package com.simplegames.finance.ViewModels;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.simplegames.finance.ViewModels.Operations.AddOperationActivity;
import com.simplegames.finance.ViewModels.Operations.ShowAllOperationsActivity;
import com.simplegames.finance.ViewModels.Products.AddProductActivity;
import com.simplegames.finance.ViewModels.Products.ShowAllProductsActivity;
import com.simplegames.finance.ViewModels.Shops.AddShopActivity;
import com.simplegames.finance.ViewModels.Shops.ShowAllShopsActivity;
import com.simplegames.finance.app.R;

public class StartActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_program);
    }

    public void addNewProduct_onClick(View view) {
        Intent intent = new Intent(StartActivity.this, AddProductActivity.class);
        startActivity(intent);
    }

    public void displayAllProducts_onClick(View view) {
        Intent intent = new Intent(StartActivity.this, ShowAllProductsActivity.class);
        startActivity(intent);
    }

    public void addNewShop_onClick(View view) {
        Intent intent = new Intent(StartActivity.this, AddShopActivity.class);
        startActivity(intent);
    }

    public void displayAllShops_onClick(View view) {
        Intent intent = new Intent(StartActivity.this, ShowAllShopsActivity.class);
        startActivity(intent);
    }

    public void displayAddNewPurchase_onClick(View view) {
        Intent intent = new Intent(StartActivity.this, AddOperationActivity.class);
        startActivity(intent);
    }

    public void displayShowAllPurchases_onClick(View view) {
        Intent intent = new Intent(StartActivity.this, ShowAllOperationsActivity.class);
        startActivity(intent);
    }
}
