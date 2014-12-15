package com.simplegames.finance.BL.Managers.Operations.Tasks;

import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.operation.Operation;
import com.simplegames.finance.dal.operationItem.OperationItem;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
* Created by andrey.kakin on 05.12.2014.
*/
public class AddOperationCallable implements Callable<Integer> {
    private IRepository<Operation> _operationRepository;
    private IRepository<OperationItem> _operationItemRepository;

    private com.simplegames.finance.BL.Model.Operation _operation;

    public AddOperationCallable(IRepository<Operation> operationRepository,
                                IRepository<OperationItem> operationItemRepository,
                                com.simplegames.finance.BL.Model.Operation operation){
        _operationRepository = operationRepository;
        _operationItemRepository = operationItemRepository;
        _operation = operation;
    }

    @Override
    public Integer call() throws Exception {
        Operation dbOperation = new Operation();
        dbOperation.Name = _operation.Name;
        dbOperation.Currency = _operation.Currency;
        dbOperation.DateTime = _operation.DateTime;
        _operationRepository.Add(dbOperation);
        ArrayList<OperationItem> operationItems = new ArrayList<OperationItem>();
        for (int i=0; i < _operation.Items.size(); i++)
        {
            com.simplegames.finance.BL.Model.OperationItem operationItem = _operation.Items.get(i);
            OperationItem dbOperationItem = new OperationItem();
            dbOperationItem.ProductId = operationItem.Product.Id;
            dbOperationItem.OperationId = dbOperation.Id;
            dbOperationItem.Price = operationItem.Price;
            _operationItemRepository.Add(dbOperationItem);
            operationItems.add(dbOperationItem);
        }
        return 1;
    }
}
