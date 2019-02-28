package com.example.retailers.server.impl;

import com.example.retailers.bean.RetailersCommodity;
import com.example.retailers.common.pagereq.BasePageReq;
import com.example.retailers.common.pageresp.PageBuilder;
import com.example.retailers.common.pageresp.Pagination;
import com.example.retailers.dao.RetailersCommodityDao;
import com.example.retailers.server.RetailersCommodityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailersCommodityServiceImpl implements RetailersCommodityService {

    @Autowired
    RetailersCommodityDao dao;


    @Override
    public RetailersCommodity find(String id) {
        return dao.find(id);
    }

    @Override
    public Pagination<RetailersCommodity> finds(BasePageReq req) {

        Page<Object> page = PageHelper.startPage(req.getCurrentPage(), req.getItemsPerPage());
        List<RetailersCommodity> retailerss ;

        retailerss = dao.finds();

        Pagination<RetailersCommodity> limits = PageBuilder.buildPageResult(page, retailerss);
        return limits;
    }

    @Override
    public int add(RetailersCommodity commodity) {
        return dao.add(commodity);
    }

    @Override
    public int delete(RetailersCommodity commodity) {
        return dao.delete(commodity);
    }

    @Override
    public int update(RetailersCommodity commodity) {
        return dao.update(commodity);
    }


}
