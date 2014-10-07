package com.simplegames.finance.dal;

import com.simplegames.finance.models.Product;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public interface IFabric {
    public IRepository<Product> GetProductRepository();
}
