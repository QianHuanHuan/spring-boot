package com.example.retailers.controller;

import com.example.retailers.common.consts.OrderInformation;
import com.example.retailers.result.BaseResult;
import com.example.retailers.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping(value = "/placeAnOrder")
    @ApiOperation("用户下单")
    public BaseResult placeAnOrder(OrderInformation information){
        return BaseResult.findBaseResult(purchaseService.placeAnOrder(information));
    }

}
