package com.simplegames.finance.dal.Common;

import com.simplegames.finance.dal.Category.Category;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.operation.Operation;
import com.simplegames.finance.dal.operationItem.OperationItem;
import com.simplegames.finance.dal.product.Product;
import com.simplegames.finance.dal.shop.Shop;

/**
 * Created by andrey.kakin on 03.10.14.
 */
public interface IFabric {
    public IRepository<Product> GetProductRepository();
    public IRepository<Shop> GetShopRepository();
    public IRepository<Operation> GetOperationRepository();
    public IRepository<OperationItem> GetOperationItemRepository();
    public IRepository<Category> GetCategoryRepository();
}
