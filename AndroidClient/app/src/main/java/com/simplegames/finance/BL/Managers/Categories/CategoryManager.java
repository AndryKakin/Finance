package com.simplegames.finance.BL.Managers.Categories;

import android.content.Context;

import com.simplegames.finance.BL.Managers.BaseDBManager;
import com.simplegames.finance.BL.Model.Category;
import com.simplegames.finance.dal.Common.IRepository;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 03.02.2015.
 */
public class CategoryManager extends BaseDBManager {
    private IRepository<com.simplegames.finance.dal.Category.Category> _categoryRepository;
    public CategoryManager(Context context) {
        super(context);
        _categoryRepository = _fabric.GetCategoryRepository();
    }

    public void Add(Category category) {
        com.simplegames.finance.dal.Category.Category dbCategory = new com.simplegames.finance.dal.Category.Category();
        dbCategory.Description = category.Description;
        dbCategory.Name = category.Name;
        if(category.Parent != null)
            dbCategory.ParentCategoryId = category.Parent.Id;
        _categoryRepository.Add(dbCategory);
    }

    public ArrayList<Category> GetAll()
    {
        ArrayList<com.simplegames.finance.dal.Category.Category> dbCategories = _categoryRepository.GetAll();
        ArrayList<Category> blCategories = new ArrayList<Category>();
        for(int i=0; i < dbCategories.size(); i++)
        {
            com.simplegames.finance.dal.Category.Category dbCategory = dbCategories.get(i);
            Category blCategory = new Category();
            blCategory.Name = dbCategory.Name;
            blCategory.Id = dbCategory.Id;
            blCategories.add(blCategory);
        }
        return blCategories;
    }
}
