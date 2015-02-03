package com.simplegames.finance.dal.DB;

import android.content.Context;

import com.simplegames.finance.dal.Category.Category;
import com.simplegames.finance.dal.Category.CategoryRepository;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.Common.IFabric;
import com.simplegames.finance.dal.operation.Operation;
import com.simplegames.finance.dal.operationItem.OperationItem;
import com.simplegames.finance.dal.operation.OperationRepository;
import com.simplegames.finance.dal.operationItem.OperationItemRepository;
import com.simplegames.finance.dal.product.ProductRepository;
import com.simplegames.finance.dal.shop.ShopRepository;
import com.simplegames.finance.dal.product.Product;
import com.simplegames.finance.dal.shop.Shop;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public class SQLiteDbFabric implements IFabric {

    public Context Context;
    @Override
    public IRepository<Product> GetProductRepository() {
        return new ProductRepository(Context);
    }

    @Override
    public IRepository<Shop> GetShopRepository() {
        return new ShopRepository(Context);
    }

    @Override
    public IRepository<Operation> GetOperationRepository() { return new OperationRepository(Context); }

    @Override
    public IRepository<OperationItem> GetOperationItemRepository() { return new OperationItemRepository(Context); }

    @Override
    public IRepository<Category> GetCategoryRepository() {
        return new CategoryRepository(Context);
    }
}
