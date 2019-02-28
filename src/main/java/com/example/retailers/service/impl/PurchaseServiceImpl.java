package com.example.retailers.service.impl;

import com.example.retailers.bean.RetailersCommodity;
import com.example.retailers.common.RedisRepository;
import com.example.retailers.common.SysUtil;
import com.example.retailers.common.consts.Keep;
import com.example.retailers.common.consts.OrderInformation;
import com.example.retailers.service.PurchaseService;
import com.example.retailers.service.RetailersCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "/purchase")
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    RedisRepository repository;
    @Autowired
    RetailersCommodityService commodityService;

    @Override
    public int placeAnOrder(OrderInformation information) {

        commodityService.updateFromRedis(information.getCommodityId(),information.getSum());


        System.out.println();
        return 0;
    }


}
