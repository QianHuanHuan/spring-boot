package com.example.retailers.controller;

import com.example.retailers.bean.RetailersOrder;
import com.example.retailers.result.BaseResult;
import com.example.retailers.service.RetailersOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/retailersOrder")
public class RetailersOrderController {

    @Autowired
    RetailersOrderService orderService;

    @PostMapping("/saveRetailersOrder")
    @ApiOperation("保存订单")
    public BaseResult saveRetailersOrder(RetailersOrder retailersOrder){
        return  BaseResult.findBaseResult(orderService.add(retailersOrder));
    }

    @PostMapping("/findRetailersOrder")
    @ApiOperation("查询订单")
    public RetailersOrder findRetailersOrder(String id){
        return orderService.find(id);
    }

    @PostMapping("/findRetailersOrders")
    @ApiOperation("查询全部订单")
    public List<RetailersOrder> findRetailersOrders(){
        return orderService.finds();
    }


}
