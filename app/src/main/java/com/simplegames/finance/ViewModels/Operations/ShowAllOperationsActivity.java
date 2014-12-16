package com.simplegames.finance.ViewModels.Operations;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simplegames.finance.BL.Managers.Operations.OperationManager;
import com.simplegames.finance.app.R;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.DB.SQLiteDbFabric;
import com.simplegames.finance.dal.operation.Operation;
import com.simplegames.finance.dal.product.Product;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 12.12.2014.
 */
public class ShowAllOperationsActivity extends ActionBarActivity {
    private OperationManager _operationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operations_activity_show_all_operations);
        _operationManager = new OperationManager(this);
        ArrayList<Operation> all = _operationManager.GetAll();
    }
}
