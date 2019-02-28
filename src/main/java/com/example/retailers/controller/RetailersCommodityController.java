package com.example.retailers.controller;

import com.example.retailers.bean.RetailersCommodity;
import com.example.retailers.common.pagereq.BasePageReq;
import com.example.retailers.common.pageresp.Pagination;
import com.example.retailers.result.BaseResult;
import com.example.retailers.service.RetailersCommodityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "/retailersCommodity")
public class RetailersCommodityController {

    @Autowired
    RetailersCommodityService commodityService;

    @PostMapping("/saveRetailersCommodity")
    @ApiOperation("添加商品信息")
    public BaseResult saveRetailersCommodity(RetailersCommodity retailersCommodity){
        return BaseResult.findBaseResult(commodityService.add(retailersCommodity));
    }

    @GetMapping("/findRetailersCommodity")
    @ApiOperation("查询商品信息")
    public RetailersCommodity findRetailersCommodity(String id){
        return commodityService.find(id);
    }

    @GetMapping("/findRetailersCommoditys")
    @ApiOperation("查询商品信息列表")
    public Pagination<RetailersCommodity> findRetailersCommoditys(BasePageReq req){
        return commodityService.finds(req);
    }

}
