package com.simplegames.finance.ViewModels.Operations;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.simplegames.finance.BL.Managers.Operations.OperationManager;
import com.simplegames.finance.ViewModels.Common.BusyActionBarActivity;
import com.simplegames.finance.ViewModels.Operations.Adapters.OperationAdapter;
import com.simplegames.finance.app.R;
import java.util.ArrayList;

/**
 * Created by andrey.kakin on 12.12.2014.
 */
public class ShowAllOperationsActivity extends BusyActionBarActivity{
    private OperationManager _operationManager;

    private LoadAllOperation _loadAllOperation;

    private OperationAdapter _operationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operations_activity_show_all_operations);
        _loadAllOperation = new LoadAllOperation();
        _loadAllOperation.execute();
    }

    private void initializeOperationAdapter(ArrayList<com.simplegames.finance.BL.Model.Operation> result)
    {
        _operationAdapter = new OperationAdapter(this,result);

        ListView listOfProducts = (ListView)findViewById(R.id.listOperationsView);
        listOfProducts.setAdapter(_operationAdapter);
        progress.hide();
    }

    private class LoadAllOperation extends AsyncTask<Void, Integer, ArrayList<com.simplegames.finance.BL.Model.Operation>>
    {
        protected void onPreExecute (){
            Log.d("PreExecute", "On pre Execute......");
            progress.setMessage("Data is loading...");
            progress.show();
        }

        protected ArrayList<com.simplegames.finance.BL.Model.Operation> doInBackground(Void...arg0) {
            Log.d("DoINBackGround","On doInBackground...");
            _operationManager = new OperationManager(getApplicationContext());
            return  _operationManager.GetAll();
        }

        protected void onProgressUpdate(Integer...a){
            Log.d("onProgressUpdate","You are in progress update ... ");
        }

        protected void onPostExecute(ArrayList<com.simplegames.finance.BL.Model.Operation> result) {
            initializeOperationAdapter(result);
        }
    }
}
