package com.simplegames.finance.BL.Managers.Operations;

import android.content.Context;

import com.simplegames.finance.BL.Managers.BaseDBManager;
import com.simplegames.finance.dal.Common.IRepository;
import com.simplegames.finance.dal.operation.Operation;
import com.simplegames.finance.dal.operationItem.OperationItem;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 31.10.2014.
 */
public class OperationManager extends BaseDBManager {
    private IRepository<Operation> _operationRepository;
    private IRepository<OperationItem> _operationItemRepository;

    public OperationManager(Context context)
    {
        super(context);
        _operationRepository = _fabric.GetOperationRepository();
        _operationItemRepository = _fabric.GetOperationItemRepository();
    }

    public void AddOperation(com.simplegames.finance.BL.Model.Operation operation)
    {
        Operation dbOperation = new Operation();
        dbOperation.Name = operation.Name;
        dbOperation.Currency = operation.Currency;
        dbOperation.DateTime = operation.DateTime;
        _operationRepository.Add(dbOperation);
        ArrayList<OperationItem> operationItems = new ArrayList<OperationItem>();
        for (int i=0; i < operation.Items.size(); i++)
        {
            com.simplegames.finance.BL.Model.OperationItem operationItem = operation.Items.get(i);
            OperationItem dbOperationItem = new OperationItem();
            dbOperationItem.ProductId = operationItem.Product.Id;
            dbOperationItem.OperationId = dbOperation.Id;
            dbOperationItem.Price = operationItem.Price;
            dbOperationItem.Count = operationItem.Count;
            _operationItemRepository.Add(dbOperationItem);
            operationItems.add(dbOperationItem);
        }
    }

    public ArrayList<com.simplegames.finance.BL.Model.Operation> GetAll()
    {
        ArrayList<com.simplegames.finance.BL.Model.Operation> result = new ArrayList<com.simplegames.finance.BL.Model.Operation>();
        ArrayList<Operation> dbOperations = _operationRepository.GetAll();
        ArrayList<OperationItem> dbOperationItems = _operationItemRepository.GetAll();
        for(int i=0; i < dbOperations.size(); i++)
        {
            Operation dbOperation = dbOperations.get(i);
            com.simplegames.finance.BL.Model.Operation blOperation = new com.simplegames.finance.BL.Model.Operation();
            blOperation.Id = dbOperation.Id;
            blOperation.DateTime = dbOperation.DateTime;
            blOperation.Currency = dbOperation.Currency;
            blOperation.Name = dbOperation.Name;
            blOperation.Items = new ArrayList< com.simplegames.finance.BL.Model.OperationItem>();
            for(int j=0; j < dbOperationItems.size(); j++)
            {
                OperationItem dbOperationItem = dbOperationItems.get(j);
                if(dbOperationItem.OperationId == dbOperation.Id)
                {
                    com.simplegames.finance.BL.Model.OperationItem blOperationItem = new com.simplegames.finance.BL.Model.OperationItem();
                    blOperationItem.Id = dbOperationItem.Id;
                    blOperationItem.Count = (int) dbOperationItem.Count;
                    blOperationItem.Price = dbOperationItem.Price;
                    blOperation.Items.add(blOperationItem);
                }
            }
            result.add(blOperation);
        }
        return result;
    }
}
