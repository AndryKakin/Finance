package com.simplegames.finance.dal.DB;

import android.content.Context;

import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.IFabric;
import com.simplegames.finance.dal.models.Operation;
import com.simplegames.finance.dal.models.OperationItem;
import com.simplegames.finance.dal.operation.OperationRepository;
import com.simplegames.finance.dal.operationItem.OperationItemRepository;
import com.simplegames.finance.dal.product.ProductRepository;
import com.simplegames.finance.dal.shop.ShopRepository;
import com.simplegames.finance.dal.models.Product;
import com.simplegames.finance.dal.models.Shop;

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
}
