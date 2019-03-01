package com.example.retailers.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.retailers.bean.RetailersOrder;
import com.example.retailers.common.RedisRepository;
import com.example.retailers.common.consts.Keep;
import com.example.retailers.dao.RetailersOrderDao;
import com.example.retailers.service.RetailersOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailersOrderServiceImpl implements RetailersOrderService {

    @Autowired
    RetailersOrderDao dao;
    @Autowired
    RedisRepository repository;

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

    @Override
    public int saveToRedis(RetailersOrder order) {


        repository.add(Keep.getKeyByName("ORDER_LIST"),JSON.toJSONString(order));


        return 0;
    }
}
