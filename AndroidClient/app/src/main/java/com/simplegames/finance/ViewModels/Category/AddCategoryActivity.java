package com.simplegames.finance.ViewModels.Category;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;

import com.simplegames.finance.BL.Managers.Categories.CategoryManager;
import com.simplegames.finance.BL.Model.Category;
import com.simplegames.finance.BL.Model.Product;
import com.simplegames.finance.ViewModels.Common.BusyActionBarActivity;
import com.simplegames.finance.ViewModels.StartActivity;
import com.simplegames.finance.app.R;

/**
 * Created by andrey.kakin on 04.02.2015.
 */
public class AddCategoryActivity extends BusyActionBarActivity {
    private CategoryManager _categoryManager;
    private static final int SELECT_PHOTO = 100;
    private Bitmap _bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_activity_add_category);
        _categoryManager = new CategoryManager(this);
    }

    public void chooseProductImage_onClick(View view)
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    //UPDATED
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_PHOTO) {
                Uri selectedImageUri = data.getData();
                String imagePath = getPath(selectedImageUri);
                _bitmap = BitmapFactory.decodeFile(imagePath);
            }

        }
    }
    public void addNewProduct_onClick(View view) {
        progress.setMessage("Product is saving...");
        progress.show();

        EditText nameEditText = (EditText)findViewById(R.id.add_product_editProductName);
        EditText descriptionEditText = (EditText)findViewById(R.id.add_product_editProductDescription);
        Category product = new Category();
        product.Name = nameEditText.getText().toString();
        product.Description = descriptionEditText.getText().toString();
        _categoryManager.Add(product);

        progress.hide();
        Intent intent = new Intent(AddCategoryActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public void cancel_onClick(View view) {
        Intent intent = new Intent(AddCategoryActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public String getPath(Uri uri) {
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }
}
