package com.example.retailers.server.impl;

import com.example.retailers.bean.RetailersOrder;
import com.example.retailers.dao.RetailersOrderDao;
import com.example.retailers.server.RetailersOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailersOrderServiceImpl implements RetailersOrderService {

    @Autowired
    RetailersOrderDao dao;

    @Override
    public RetailersOrder find(String id) {
        return dao.find(id);
    }

    @Override
    public List<RetailersOrder> finds() {
        return dao.finds();
    }

    @Override
    public int add(RetailersOrder order) {
        return dao.add(order);
    }

    @Override
    public int delete(RetailersOrder order) {
        return dao.delete(order);
    }

    @Override
    public int update(RetailersOrder order) {
        return dao.update(order);
    }
}
