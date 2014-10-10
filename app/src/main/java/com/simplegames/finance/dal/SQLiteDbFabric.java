package com.simplegames.finance.dal;

import android.content.Context;

import com.simplegames.finance.dal.product.ProductRepository;
import com.simplegames.finance.models.Product;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class SQLiteDbFabric implements IFabric{

    public Context Context;
    @Override
    public IRepository<Product> GetProductRepository() {
        return new ProductRepository(Context);
    }
}
