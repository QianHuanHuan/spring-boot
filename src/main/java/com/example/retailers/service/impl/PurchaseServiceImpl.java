package com.example.retailers.service.impl;

import com.example.retailers.bean.RetailersOrder;
import com.example.retailers.common.RedisRepository;
import com.example.retailers.common.consts.OrderInformation;
import com.example.retailers.service.PurchaseService;
import com.example.retailers.service.RetailersCommodityService;
import com.example.retailers.service.RetailersOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private volatile boolean stop;

    @Autowired
    RedisRepository repository;
    @Autowired
    RetailersCommodityService commodityService;
    @Autowired
    RetailersOrderService orderService;

    @Override
    public int placeAnOrder(OrderInformation information) {

        boolean flag = commodityService.updateFromRedis(information.getCommodityId(),information.getSum());
        if (!flag) return 0;

        RetailersOrder order = new RetailersOrder();

        order.setCommodityId(information.getCommodityId());
        order.setSum(information.getSum());
        order.setUserId(information.getUserId());
        order.setRemarks("---");

        orderService.saveToRedis(order);

        stop = false;
        return 1;
    }

    class ExecuteCancelOrdr implements Runnable {


        @Override
        public void run() {
            while (!stop) {
                //取订单  入库
                System.out.println("....................................");
            }
        }
    }



}
