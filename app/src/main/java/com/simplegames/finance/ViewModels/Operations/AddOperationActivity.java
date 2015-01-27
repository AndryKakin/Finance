package com.simplegames.finance.ViewModels.Operations;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by andrey.kakin on 29.10.2014.
 */
public class AddOperationActivity extends BusyActionBarActivity {
    static final int DATE_DIALOG_ID = 999;
    static final int TIME_DIALOG_ID = 998;

    com.simplegames.finance.BL.Model.Operation _operation = new com.simplegames.finance.BL.Model.Operation();
    private OperationManager _operationManager;
    private ProductManager _productManager;
    private SimpleDateFormat _dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private SimpleDateFormat _timeFormat = new SimpleDateFormat("HH:mm:ss");


    private ArrayList<Product> _availableProducts;
    private ArrayList<ProductVM> _productVMs;
    private ArrayList<OperationItem> _purchaseItems;

    private ProductsAdapter _productAdapter;
    private PurchasesAdapter _purchaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.operations_activity_add_operation);
        _operation.Currency = "RUB";
        Calendar cal = Calendar.getInstance();
        Date t = cal.getTime();
        _operation.DateTime = new Date();

        progress.setMessage("Data is loading...");
        progress.show();

        Date date = new Date();

        Button dateView = (Button)findViewById(R.id.operationDateView);
        dateView.setText(_dateFormat.format(date));
        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);

            }
        });

        Button timeView = (Button)findViewById(R.id.operationTimeView);
        timeView.setText(_timeFormat.format(date));
        timeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);

            }
        });

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
        for(int i=0; i < _purchaseAdapter.getCount(); i++)
        {
            _operation.Items.add(_purchaseAdapter.getItem(i));
        }
        AddNewOperationUITask addNewOperationUITask = new AddNewOperationUITask();
        addNewOperationUITask.execute(_operation);
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

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener,
                        _operation.DateTime.getYear() + 1900,
                        _operation.DateTime.getMonth(),
                        _operation.DateTime.getDate());
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,timePickerListener,
                        _operation.DateTime.getHours(),
                        _operation.DateTime.getMinutes(),true);
        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            _operation.DateTime.setHours(hourOfDay);
            _operation.DateTime.setMinutes(minute);
            Button timeView = (Button)findViewById(R.id.operationTimeView);
            timeView.setText(_timeFormat.format(_operation.DateTime));
        }
    };

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            _operation.DateTime.setYear(selectedYear - 1900);
            _operation.DateTime.setMonth(selectedMonth);
            _operation.DateTime.setDate(selectedDay);
            Button dateView = (Button)findViewById(R.id.operationDateView);
            dateView.setText(_dateFormat.format(_operation.DateTime));
        }
    };
}
