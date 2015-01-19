package com.simplegames.finance.ViewModels.Operations;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.simplegames.finance.app.R;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 13.11.2014.
 */
public class ProductsAdapter extends BaseAdapter {

    private ArrayList<ProductVM> _data;
    private ActionBarActivity _context;
    public ProductsAdapter(ActionBarActivity context,ArrayList<ProductVM> products)
    {
        _context = context;
        _data  = new ArrayList<ProductVM>(products);
    }
    public void add(ProductVM product)
    {
        _data.add(product);
        this.notifyDataSetChanged();
    }

    public void remove(ProductVM product)
    {
        _data.remove(product);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public ProductVM getItem(int position) {
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
        ((ImageView) convertView.findViewById(R.id.productImageView)).setImageBitmap(getItem(position).Bitmap);

        ((TextView) convertView.findViewById(R.id.productNameView))
                .setText(getItem(position).Name);

        ((EditText) convertView.findViewById(R.id.editProductCostView))
                .setText(Long.toString(getItem(position).Id));

        SetSelectedView(position, convertView);

        convertView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                ProductVM product = getItem(position);
                product.IsSelected = !product.IsSelected;
                SetSelectedView(position, v);

            }
        });

        return convertView;
    }

    private void SetSelectedView(int position, View convertView) {
        ProductVM tempProduct = getItem(position);
        if(tempProduct.IsSelected)
            convertView.setBackgroundColor(Color.rgb(128, 185, 249));
        else
            convertView.setBackgroundColor(Color.rgb(147, 250, 141));
    }
}
