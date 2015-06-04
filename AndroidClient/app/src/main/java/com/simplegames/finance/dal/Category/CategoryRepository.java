package com.simplegames.finance.dal.Category;

import android.content.Context;

import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.DB.FinanceDataBase;
import com.simplegames.finance.dal.product.ProductTable;

import java.util.ArrayList;
import android.database.sqlite.*;
import android.content.*;
import android.database.*;
import android.util.*;

/**
 * Created by andrey.kakin on 30.01.2015.
 */
public class CategoryRepository implements IRepository<Category> {

    private FinanceDataBase _financeDataBase;
    private CategoryTable _categoryTable = new CategoryTable();

    public CategoryRepository(Context context)
    {
        _financeDataBase = new FinanceDataBase(context);
    }

    @Override
    public void Add(Category category) {
		SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(_categoryTable.NameColumnName, category.Name);
        cv.put(_categoryTable.DescriptionColumnName,category.Description);
		cv.put(_categoryTable.CategoryToCategoryColumnName,category.ParentCategoryId);
        category.Id = sqdb.insert(ProductTable.TableName, null, cv);
        sqdb.close();
    }

    @Override
    public void Remove(Category item) {

    }

    @Override
    public void Update(Category category) {
		SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        ContentValues cv = new ContentValues();
		cv.put(_categoryTable.IdColumnName,category.Id);
        cv.put(_categoryTable.NameColumnName, category.Name);
        cv.put(_categoryTable.DescriptionColumnName,category.Description);
		cv.put(_categoryTable.CategoryToCategoryColumnName,category.ParentCategoryId);
        category.Id = sqdb.update(CategoryTable.TableName, cv,null,null);
        sqdb.close();
    }

    @Override
    public ArrayList<Category> GetAll() {
        SQLiteDatabase sqdb = _financeDataBase.getWritableDatabase();
        Cursor cursor = sqdb.query(CategoryTable.TableName, new String[] {
									   _categoryTable.IdColumnName,
									   _categoryTable.NameColumnName,
									   _categoryTable.DescriptionColumnName,
									   _categoryTable.CategoryToCategoryColumnName},
								   null, // The columns for the WHERE clause
								   null, // The values for the WHERE clause
								   null, // don't group the rows
								   null, // don't filter by row groups
								   null // The sort order
								   );
        ArrayList<Category> result = new ArrayList<Category>();
        while (cursor.moveToNext()) {
            // GET COLUMN INDICES + VALUES OF THOSE COLUMNS
            long id = cursor.getInt(cursor.getColumnIndex(_categoryTable.IdColumnName));

            String name = cursor.getString(cursor.getColumnIndex(_categoryTable.NameColumnName));

            String description = cursor.getString(cursor.getColumnIndex(_categoryTable.DescriptionColumnName));

            long parentId = cursor.getInt(cursor.getColumnIndex(_categoryTable.CategoryToCategoryColumnName));

            Log.i("LOG_TAG", "ROW " + id + " NAME " + name + " DESCRIPTION " + description);
            Category category = new Category();
            category.Id = id;
            category.Name = name;
            category.Description = description;
            category.ParentCategoryId = parentId;
            result.add(category);
        }
        cursor.close();
        return result;
    }
}
