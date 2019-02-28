package com.example.retailers.server;

import com.example.retailers.bean.RetailersCommodity;
import com.example.retailers.common.pagereq.BasePageReq;
import com.example.retailers.common.pageresp.Pagination;


public interface RetailersCommodityService {

    RetailersCommodity find(String id);
    Pagination<RetailersCommodity> finds(BasePageReq req);
    int add(RetailersCommodity commodity);
    int delete(RetailersCommodity commodity);
    int update(RetailersCommodity commodity);

}
