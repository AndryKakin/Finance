package com.simplegames.finance.BL.Managers.Products;

import android.content.Context;

import com.simplegames.finance.BL.Managers.BaseDBManager;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.product.Product;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class ProductManager extends BaseDBManager {
    private IRepository<Product> _productRepository;

    public ProductManager(Context context) {
        super(context);
        _productRepository = _fabric.GetProductRepository();
    }
    public void Add(Product item) {
        _productRepository.Add(item);
    }

    public ArrayList<com.simplegames.finance.BL.Model.Product> GetAll()
    {
        ArrayList<Product> dbProducts = _productRepository.GetAll();
        ArrayList<com.simplegames.finance.BL.Model.Product> products = new ArrayList<com.simplegames.finance.BL.Model.Product>();
        for(int i=0; i < dbProducts.size(); i++)
        {
            Product dbProduct = dbProducts.get(i);
            com.simplegames.finance.BL.Model.Product product = new com.simplegames.finance.BL.Model.Product();
            product.Name = dbProduct.Name;
            product.Id = dbProduct.Id;
            products.add(product);
        }
        return products;
    }
}
