package com.example.retailers.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.retailers.bean.RetailersCommodity;
import com.example.retailers.common.RedisRepository;
import com.example.retailers.common.SysUtil;
import com.example.retailers.common.consts.Keep;
import com.example.retailers.common.pagereq.BasePageReq;
import com.example.retailers.common.pageresp.PageBuilder;
import com.example.retailers.common.pageresp.Pagination;
import com.example.retailers.dao.RetailersCommodityDao;
import com.example.retailers.service.RetailersCommodityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailersCommodityServiceImpl implements RetailersCommodityService {

    @Autowired
    RetailersCommodityDao dao;
    @Autowired
    RedisRepository repository;


    /**
     * 通过redis获取RetailersCommodity对象
     * @param id
     * @return
     */
    @Override
    public RetailersCommodity findFromRedis(String id) {
        String commodityKey = Keep.getKeyByName("COMMODITY");
        String commodityKeyNum = Keep.getKeyByName("COMMODITY_NUMBER");
        commodityKey = commodityKey+id;
        commodityKeyNum = commodityKeyNum+id;

        String commodityJson =  repository.get(commodityKey);
        RetailersCommodity retailersCommodity ;

        if (SysUtil.isNullOrEmpty(commodityJson)) {
            retailersCommodity = dao.find(id);
            commodityJson = JSON.toJSONString(retailersCommodity);
            repository.set(commodityKey,commodityJson,600L);
            repository.set(commodityKeyNum,retailersCommodity.getStock()+"",600L);
        }else{
            String num =  repository.get(commodityKeyNum);
            retailersCommodity = (RetailersCommodity) JSON.parse(commodityJson);
            retailersCommodity.setStock(SysUtil.toInt(retailersCommodity));
        }
        return retailersCommodity;
    }

    @Override
    public int updateFromRedis(String id,int num) {
        String commodityKeyNum = Keep.getKeyByName("COMMODITY_NUMBER");
        commodityKeyNum = commodityKeyNum+id;
        String olNum =  repository.get(commodityKeyNum);

        if (SysUtil.isNullOrEmpty(olNum)) {
            findFromRedis(id);
        }
        long end = repository.incr(commodityKeyNum,-num,600L);

        if (end < 0){
            return -1;
        }
        return 0;
    }

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
