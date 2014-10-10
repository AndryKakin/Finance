package com.simplegames.finance.BL;

import com.simplegames.finance.dal.IRepository;
import com.simplegames.finance.models.Product;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public class ProductManager {
    private IRepository<Product> _productRepository;

    public void Add(Product item) {
        _productRepository.Add(item);
    }
}
