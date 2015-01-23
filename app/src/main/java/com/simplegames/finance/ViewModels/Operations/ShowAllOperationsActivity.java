package com.simplegames.finance.ViewModels.Operations;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simplegames.finance.BL.Managers.Operations.OperationManager;
import com.simplegames.finance.BL.Model.OperationItem;
import com.simplegames.finance.ViewModels.Common.BusyActionBarActivity;
import com.simplegames.finance.ViewModels.Operations.Adapters.OperationAdapter;
import com.simplegames.finance.ViewModels.Operations.Adapters.PurchasesAdapter;
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
public class ShowAllOperationsActivity extends BusyActionBarActivity {
    private OperationManager _operationManager;

    private ArrayList<com.simplegames.finance.BL.Model.Operation> _blOperations;

    private OperationAdapter _operationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operations_activity_show_all_operations);
        progress.setMessage("Data is loading...");
        progress.show();

        _operationManager = new OperationManager(this);
        _blOperations = _operationManager.GetAll();
        _operationAdapter = new OperationAdapter(this,_blOperations);

        ListView listOfProducts = (ListView)findViewById(R.id.listOperationsView);
        listOfProducts.setAdapter(_operationAdapter);
        progress.hide();
    }
}
