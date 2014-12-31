package com.simplegames.finance.ViewModels.Products;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.simplegames.finance.BL.Managers.Products.ProductManager;
import com.simplegames.finance.ViewModels.StartActivity;
import com.simplegames.finance.app.R;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.DB.SQLiteDbFabric;
import com.simplegames.finance.dal.product.Product;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class AddProductActivity extends ActionBarActivity {
    private ProductManager _productManager;
    private static final int SELECT_PHOTO = 100;
    //YOU CAN EDIT THIS TO WHATEVER YOU WANT
    private static final int SELECT_PICTURE = 1;
    ImageView img,img1;
    int column_index;
    Intent intent=null;
    String selectedImagePath;
    //ADDED
    String filemanagerstring;

    // Declare our Views, so we can access them later
    String logo,imagePath,Logo;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity_add_product);
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

                //OI FILE Manager
                filemanagerstring = selectedImageUri.getPath();

                //MEDIA GALLERY
                selectedImagePath = getPath(selectedImageUri);


                Bitmap bm = BitmapFactory.decodeFile(imagePath);

                int size = bm.getAllocationByteCount();
                // img1.setImageBitmap(bm);
                ByteArrayOutputStream memory = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 100, memory);
                int sizeInMemory = memory.size();

            }

        }
    }
    public void addNewProduct_onClick(View view) {
        EditText nameEditText = (EditText)findViewById(R.id.add_product_editProductName);
        EditText descriptionEditText = (EditText)findViewById(R.id.add_product_editProductDescription);
        Product product = new Product();
        product.Name = nameEditText.getText().toString();
        product.Description = descriptionEditText.getText().toString();
        _productManager.Add(product);

        Intent intent = new Intent(AddProductActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public void cancel_onClick(View view) {
        Intent intent = new Intent(AddProductActivity.this, StartActivity.class);
        startActivity(intent);
    }

    public String getPath(Uri uri) {
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        column_index = cursor
                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        imagePath = cursor.getString(column_index);

        return cursor.getString(column_index);
    }
}