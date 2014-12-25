package com.simplegames.finance.ViewModels.Operations;

import android.graphics.Color;
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
    }
    public void add(Product product)
    {
        _data.add(product);
        this.notifyDataSetChanged();
    }

    public void remove(Product product)
    {
        _data.remove(product);
        this.notifyDataSetChanged();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = _context.getLayoutInflater().inflate(R.layout.template_operation_product_item, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.productNameView))
                .setText(getItem(position).Name);

        ((EditText) convertView.findViewById(R.id.editProductCostView))
                .setText(Long.toString(getItem(position).Id));

        SetSelectedView(position, convertView);

        convertView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Product product = getItem(position);
                product.IsSelected = !product.IsSelected;
                SetSelectedView(position, v);

            }
        });

        return convertView;
    }

    private void SetSelectedView(int position, View convertView) {
        Product tempProduct = getItem(position);
        if(tempProduct.IsSelected)
            convertView.setBackgroundColor(Color.rgb(226, 11, 11));
        else
            convertView.setBackgroundColor(Color.rgb(26, 55, 65));
    }
}
