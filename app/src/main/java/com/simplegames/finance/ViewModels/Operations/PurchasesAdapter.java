package com.simplegames.finance.ViewModels.Operations;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.simplegames.finance.BL.Model.OperationItem;
import com.simplegames.finance.app.R;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 14.11.2014.
 */
public class PurchasesAdapter extends BaseAdapter {

    private ArrayList<OperationItem> _data;
    private ActionBarActivity _context;

    public PurchasesAdapter(ActionBarActivity context,ArrayList<OperationItem> products)
    {
        SelectedItem = null;
        _context = context;
        _data  = new ArrayList<OperationItem>(products);
    }

    public OperationItem SelectedItem;

    public void Add(OperationItem operationItem)
    {
        _data.add(operationItem);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public OperationItem getItem(int position) {
        return _data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _data.get(position).hashCode();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = _context.getLayoutInflater().inflate(R.layout.template_operation_purchase_item, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.productNameView))
                .setText(getItem(position).Product.Name);

        ((EditText) convertView.findViewById(R.id.editProductPriceView))
                .setText("$" + getItem(position).Price);
        convertView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                SelectedItem = getItem(position);
            }
        });
        return convertView;
    }
}