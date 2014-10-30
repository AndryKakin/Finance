package com.simplegames.finance.dal;

import com.simplegames.finance.dal.models.Operation;
import com.simplegames.finance.dal.models.OperationItem;
import com.simplegames.finance.dal.models.Product;
import com.simplegames.finance.dal.models.Shop;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public interface IFabric {
    public IRepository<Product> GetProductRepository();
    public IRepository<Shop> GetShopRepository();
    public IRepository<Operation> GetOperationRepository();
    public IRepository<OperationItem> GetOperationItemRepository();
}
