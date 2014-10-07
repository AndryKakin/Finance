package com.simplegames.finance.dal;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 02.10.14.
 */
public interface IRepository<T> {
    void Add(T item);
    void Remove(T item);
    void Update(T item);
    ArrayList<T> GetAll();
}
