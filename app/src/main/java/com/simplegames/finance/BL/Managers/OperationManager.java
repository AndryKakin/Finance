package com.simplegames.finance.BL.Managers;

import android.content.Context;

import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.DB.SQLiteDbFabric;
import com.simplegames.finance.dal.models.Operation;
import com.simplegames.finance.dal.models.OperationItem;
import com.simplegames.finance.dal.models.Product;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 31.10.2014.
 */
public class OperationManager extends BaseDBManager{
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

    public void AddOperation(com.simplegames.finance.BL.Model.Operation operation)
    {
        Operation dbOperation = new Operation();
        dbOperation.DateTime = operation.DateTime;
        dbOperation.Items = new ArrayList<OperationItem>();
        for (int i=0; i < operation.Items.size(); i++)
        {
            com.simplegames.finance.BL.Model.OperationItem operationItem;
            operationItem = operation.Items.get(i);
            OperationItem dbOperationItem = new OperationItem();
            dbOperationItem.Price = operationItem.Price;
            dbOperation.Items.add(dbOperationItem);
        }
        _operationRepository.Add(dbOperation);
    }
}
