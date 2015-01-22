package com.simplegames.finance.ViewModels.Operations.Models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class ProductVM {
    List<ProductSelectListener> listeners = new ArrayList<ProductSelectListener>();

    public void addListener(ProductSelectListener toAdd) {
        listeners.add(toAdd);
    }

    public long Id;
    public String Name;
    public String Description;
    public Bitmap Bitmap;
    public boolean IsSelected;

    public void Select()
    {
        for (ProductSelectListener hl : listeners)
            hl.OnSelected(this);
    }
}
