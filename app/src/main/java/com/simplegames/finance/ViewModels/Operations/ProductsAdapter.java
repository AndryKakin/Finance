package com.simplegames.finance.ViewModels.Operations;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.simplegames.finance.BL.Model.Product;
import com.simplegames.finance.app.R;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 13.11.2014.
 */
public class ProductsAdapter extends BaseAdapter {

    private ArrayList<Product> _data;
    private ActionBarActivity _context;
    public ProductsAdapter(ActionBarActivity context,ArrayList<Product> products)
    {
        SelectedItem = null;
        _context = context;
        _data  = new ArrayList<Product>(products);
    }

    public Product SelectedItem;

    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public Product getItem(int position) {
        return _data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _data.get(position).hashCode();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = _context.getLayoutInflater().inflate(R.layout.template_operation_product_item, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.productNameView))
                .setText(getItem(position).Name);

        ((EditText) convertView.findViewById(R.id.editProductCostView))
                .setText(Long.toString(getItem(position).Id));

        convertView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                SelectedItem = getItem(position);
            }
        });

        return convertView;
    }
}
