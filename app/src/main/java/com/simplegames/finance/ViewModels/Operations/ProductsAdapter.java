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
        _context = context;
        _data  = new ArrayList<Product>(products);
        Product product1 = new Product();
        product1.Name = "Test";
        product1.Id = 34;
        _data.add(product1);

        Product product2 = new Product();
        product2.Name = "sdfs";
        product2.Id = 3223;
        _data.add(product2);
    }

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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = _context.getLayoutInflater().inflate(R.layout.operation_items_template, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.productNameView))
                .setText(getItem(position).Name);

        ((EditText) convertView.findViewById(R.id.editProductCostView))
                .setText(Integer.toString(getItem(position).Id));
        return convertView;
    }
}
