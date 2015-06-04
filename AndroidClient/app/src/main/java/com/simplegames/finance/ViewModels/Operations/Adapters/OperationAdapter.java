package com.simplegames.finance.ViewModels.Operations.Adapters;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.simplegames.finance.BL.Model.Operation;
import com.simplegames.finance.BL.Model.OperationItem;
import com.simplegames.finance.app.R;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 21.01.2015.
 */
public class OperationAdapter extends BaseAdapter {

    private ArrayList<Operation> _data;
    private ActionBarActivity _context;

    public OperationAdapter(ActionBarActivity context, ArrayList<Operation> operations) {
        _context = context;
        _data = new ArrayList<Operation>(operations);
    }

    public void add(Operation operation) {
        _data.add(operation);
        this.notifyDataSetChanged();
    }

    public void remove(OperationItem operationItem) {
        _data.remove(operationItem);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public Operation getItem(int position) {
        return _data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _data.get(position).hashCode();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = _context.getLayoutInflater().inflate(R.layout.template_operation_item, parent, false);
        }

        Operation currentOperation = getItem(position);
        double totalPrice = 0;
        for(int i=0; i<currentOperation.Items.size(); i++)
        {
            totalPrice += currentOperation.Items.get(i).Price;
        }

        ((TextView) convertView.findViewById(R.id.operationNameView)).setText(currentOperation.Name);
        ((TextView) convertView.findViewById(R.id.operationTimeView)).setText(currentOperation.DateTime.toString());
        ((TextView) convertView.findViewById(R.id.operationCountView)).setText(Integer.toString(currentOperation.Items.size()));
        ((EditText) convertView.findViewById(R.id.operationPriceView)).setText(currentOperation.Currency + totalPrice);

        return convertView;
    }
}