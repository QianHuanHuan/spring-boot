package com.example.retailers.service;

import com.example.retailers.bean.RetailersOrder;

import java.util.List;

public interface RetailersOrderService {


    RetailersOrder find(String id);
    List<RetailersOrder> finds();
    int add(RetailersOrder order);
    int delete(RetailersOrder order);
    int update(RetailersOrder order);
}
