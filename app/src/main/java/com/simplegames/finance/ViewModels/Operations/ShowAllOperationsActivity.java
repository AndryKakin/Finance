package com.simplegames.finance.ViewModels.Operations;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simplegames.finance.BL.Managers.Operations.OperationManager;
import com.simplegames.finance.BL.Model.OperationItem;
import com.simplegames.finance.app.R;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.DB.SQLiteDbFabric;
import com.simplegames.finance.dal.operation.Operation;
import com.simplegames.finance.dal.product.Product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by andrey.kakin on 12.12.2014.
 */
public class ShowAllOperationsActivity extends ActionBarActivity {
    private OperationManager _operationManager;

    private ArrayList<com.simplegames.finance.BL.Model.Operation> _blOperations;

    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operations_activity_show_all_operations);
        _operationManager = new OperationManager(this);
        _blOperations = _operationManager.GetAll();
        ArrayList<String> operationsVM = new ArrayList<String>();
        for (int i=0; i < _blOperations.size(); i++)
        {
            com.simplegames.finance.BL.Model.Operation blOperation =_blOperations.get(i);
            double price = 0;
            for(int g=0; g < blOperation.Items.size(); g++)
            {
                OperationItem blOperationItem = blOperation.Items.get(g);
                price += blOperationItem.Price * blOperationItem.Count;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            operationsVM.add("Date: " + sdf.format(blOperation.DateTime) + "Price: " + price);
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, operationsVM);
        ListView listOfProducts = (ListView)findViewById(R.id.listOperationsView);
        listOfProducts.setAdapter(adapter);
    }
}
