package com.simplegames.finance.ViewModels.Operations.Adapters;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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

        OperationItem operationItem = getItem(position);
        TextView productNameView = (TextView)convertView.findViewById(R.id.productNameView);
        productNameView.setText(operationItem.Product.Name);

        final EditText editPriceView = ((EditText) convertView.findViewById(R.id.editProductPriceView));
        editPriceView.setText("$" + operationItem.Price);
        editPriceView.addTextChangedListener(new TextWatcher() {

            private String _previousDigits;
            private boolean _textChanged = false;
            private int _previewCursorPositionStart = 0;
            private int _previewCursorPositionEnd = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                _previousDigits = s.toString();
                _previewCursorPositionStart = editPriceView.getSelectionStart();
                _previewCursorPositionEnd = editPriceView.getSelectionEnd();
            }

            @Override
            public void onTextChanged(CharSequence currentDigits, int start,
                                      int before, int count) {
                String input = currentDigits.toString();
                if (!(_previousDigits.equalsIgnoreCase(input)) && input.length() > 1) {
                    _textChanged = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (_textChanged) {
                    _textChanged = false;

                    String value = s.toString().substring(1,s.toString().length());
                    editPriceView.setText(s);
                    editPriceView.setSelection(_previewCursorPositionStart,_previewCursorPositionEnd);
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

        final EditText editCountView = (EditText) convertView.findViewById(R.id.editProductCountView);
        editCountView.setText(Integer.toString(operationItem.Count));

        Button upCountButton = (Button) convertView.findViewById(R.id.upCountButtonView);
        upCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationItem operationItem = getItem(position);
                operationItem.Count++;
                editCountView.setText(Integer.toString(operationItem.Count));
            }
        });
        Button downCountButton = (Button) convertView.findViewById(R.id.downCountButtonView);
        downCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationItem operationItem = getItem(position);
                if(operationItem.Count > 1)
                {
                    operationItem.Count--;
                }
                editCountView.setText(Integer.toString(operationItem.Count));
            }
        });
        return convertView;
    }
}