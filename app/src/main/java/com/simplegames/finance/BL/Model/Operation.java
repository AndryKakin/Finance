package com.simplegames.finance.BL.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by andrey.kakin on 31.10.2014.
 */
public class Operation extends BLBaseModel{
    public Operation()
    {
        Items = new ArrayList<OperationItem>();
    }
    public Date DateTime;
    public ArrayList<OperationItem> Items;
}
