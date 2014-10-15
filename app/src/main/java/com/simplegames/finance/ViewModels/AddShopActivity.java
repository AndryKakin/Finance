package com.simplegames.finance.ViewModels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.simplegames.finance.app.R;
import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.dal.SQLiteDbFabric;
import com.simplegames.finance.models.Shop;

/**
 * Created by Andrey on 11.10.2014.
 */
public class AddShopActivity extends ActionBarActivity {
    private SQLiteDbFabric _fabric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop);
        _fabric = new SQLiteDbFabric();
        _fabric.Context = this;
    }

    public void addNewProduct_onClick(View view) {
        EditText nameEditText = (EditText)findViewById(R.id.add_shop_editName);
        EditText descriptionEditText = (EditText)findViewById(R.id.add_shop_editDescription);
        IRepository<Shop> shopRepository = _fabric.GetShopRepository();
        Shop shop = new Shop();
        shop.Name = nameEditText.getText().toString();
        shop.Description = descriptionEditText.getText().toString();
        shopRepository.Add(shop);

        Intent intent = new Intent(AddShopActivity.this, StartActivity.class);
        startActivity(intent);
    }
}
