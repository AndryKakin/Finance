package com.simplegames.finance.ViewModels.Operations;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.simplegames.finance.BL.Model.OperationItem;
import com.simplegames.finance.BL.Model.Product;
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
        _context = context;
        _data  = new ArrayList<OperationItem>(products);
    }

    public void add(OperationItem operationItem)
    {
        _data.add(operationItem);
        this.notifyDataSetChanged();
    }

    public void remove(OperationItem operationItem)
    {
        _data.remove(operationItem);
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

        final EditText editPriceView = ((EditText) convertView.findViewById(R.id.editProductPriceView));
        editPriceView.setText("$" + getItem(position).Price);
        editPriceView.addTextChangedListener(new TextWatcher() {

            private String previousDigits, num;
            private boolean textChanged = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                previousDigits = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence currentDigits, int start,
                                      int before, int count) {
                String input = currentDigits.toString();
                if (!(previousDigits.equalsIgnoreCase(input)) && input.length() > 1) {
                    textChanged = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (textChanged) {
                    textChanged = false;

                    String value = s.toString().substring(1,s.toString().length());
                    editPriceView.setText(s);
                    try {
                        double val = Double.parseDouble(value);
                        OperationItem operationItem = getItem(position);
                        operationItem.Price = val;
                    } catch (NumberFormatException e) {
                        // Handle exception
                        e.printStackTrace();
                    }

                }

            }

        });

        return convertView;
    }
}