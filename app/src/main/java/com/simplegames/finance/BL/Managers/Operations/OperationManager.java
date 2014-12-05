package com.simplegames.finance.BL.Managers.Operations;

import android.content.Context;

import com.simplegames.finance.BL.Managers.BaseDBManager;
import com.simplegames.finance.BL.Managers.Operations.Tasks.AddOperationCallable;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.operation.Operation;
import com.simplegames.finance.dal.operationItem.OperationItem;
import com.simplegames.finance.dal.product.Product;

import java.util.concurrent.FutureTask;

/**
 * Created by andrey.kakin on 31.10.2014.
 */
public class OperationManager extends BaseDBManager {
    private IRepository<Operation> _operationRepository;
    private IRepository<OperationItem> _operationItemRepository;
    private IRepository<Product> _productRepository;

    public OperationManager(Context context)
    {
        super(context);
        _operationRepository = _fabric.GetOperationRepository();
        _operationItemRepository = _fabric.GetOperationItemRepository();
        _productRepository = _fabric.GetProductRepository();
    }

    public FutureTask AddOperation(com.simplegames.finance.BL.Model.Operation operation)
    {
        return new FutureTask(new AddOperationCallable(
                    _operationRepository,
                    _operationItemRepository,
                    operation));
    }
}
