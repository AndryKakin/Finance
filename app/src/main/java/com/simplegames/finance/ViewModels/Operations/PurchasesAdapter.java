package com.simplegames.finance.ViewModels.Operations;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.simplegames.finance.BL.Model.OperationItem;
import com.simplegames.finance.BL.Model.Product;
import com.simplegames.finance.app.R;

import java.math.BigDecimal;
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
        OperationItem item1 = new OperationItem();
        item1.Price = BigDecimal.valueOf(45.0);
        item1.Id = 1;
        item1.Product = new Product();
        item1.Product.Name = "Book Stevean Hooking";
        item1.Product.Id = 12;
        _data.add(item1);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = _context.getLayoutInflater().inflate(R.layout.template_operation_purchase_item, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.productNameView))
                .setText(getItem(position).Product.Name);

        ((EditText) convertView.findViewById(R.id.editProductPriceView))
                .setText("$" + getItem(position).Price.toString());
        return convertView;
    }
}