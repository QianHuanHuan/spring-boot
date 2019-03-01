package com.example.retailers.service;

import com.example.retailers.bean.RetailersCommodity;
import com.example.retailers.common.pagereq.BasePageReq;
import com.example.retailers.common.pageresp.Pagination;


public interface RetailersCommodityService {

    RetailersCommodity find(String id);
    RetailersCommodity findFromRedis(String id);
    boolean updateFromRedis(String id,int num);
    Pagination<RetailersCommodity> finds(BasePageReq req);
    int add(RetailersCommodity commodity);
    int delete(RetailersCommodity commodity);
    int update(RetailersCommodity commodity);

}
