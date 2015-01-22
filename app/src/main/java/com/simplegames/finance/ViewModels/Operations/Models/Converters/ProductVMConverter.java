package com.simplegames.finance.ViewModels.Operations.Models.Converters;

import com.simplegames.finance.BL.Model.Product;
import com.simplegames.finance.ViewModels.Operations.Models.ProductVM;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 22.01.2015.
 */
public class ProductVMConverter {
    public static ArrayList<ProductVM> ConvertProductsBLToVM(ArrayList<Product> blProducts) {
        ArrayList<ProductVM> result = new ArrayList<ProductVM>();
        for(int i=0; i<blProducts.size(); i++)
        {
            result.add(ConvertProductBLToVM(blProducts.get(i)));
        }
        return result;
    }

    public static ProductVM ConvertProductBLToVM(Product product) {
        ProductVM productVM = new ProductVM();
        productVM.Bitmap = product.Bitmap;
        productVM.Description = product.Description;
        productVM.Id = product.Id;
        productVM.Name =  product.Name;
        return productVM;
    }

    public static Product ConvertVMToBL(ProductVM productVM) {
        Product product = new Product();
        product.Bitmap = productVM.Bitmap;
        product.Description = productVM.Description;
        product.Id = productVM.Id;
        product.Name =  productVM.Name;
        return product;
    }
}
