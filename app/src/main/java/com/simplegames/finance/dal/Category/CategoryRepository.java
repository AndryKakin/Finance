package com.simplegames.finance.dal.Category;

import android.content.Context;

import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.DB.FinanceDataBase;
import com.simplegames.finance.dal.product.ProductTable;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 30.01.2015.
 */
public class CategoryRepository implements IRepository<Category> {

    private FinanceDataBase _financeDataBase;
    private ProductTable _productTable = new ProductTable();

    public CategoryRepository(Context context)
    {
        _financeDataBase = new FinanceDataBase(context);
    }

    @Override
    public void Add(Category item) {

    }

    @Override
    public void Remove(Category item) {

    }

    @Override
    public void Update(Category item) {

    }

    @Override
    public ArrayList<Category> GetAll() {
        return null;
    }
}
