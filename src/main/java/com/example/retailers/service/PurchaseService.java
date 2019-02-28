package com.example.retailers.service;

import com.example.retailers.common.consts.OrderInformation;

public interface PurchaseService {

    /**
     * 用户下单
     * @param information 下单信息
     * @return
     */
    int placeAnOrder(OrderInformation information);

}
