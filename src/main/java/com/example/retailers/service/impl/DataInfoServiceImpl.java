package com.example.retailers.service.impl;

import com.example.retailers.bean.DataInfo;
import com.example.retailers.common.RedisRepository;
import com.example.retailers.dao.DataInfoDao;
import com.example.retailers.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DataInfoServiceImpl implements DataInfoService {


    @Autowired
    RedisRepository repository;

    @Autowired
    DataInfoDao dataInfoDao;

    @Override
    public DataInfo find(Integer id) {
        return dataInfoDao.find(id);
    }

    @Override
    public List<DataInfo> finds() {
        return dataInfoDao.finds();
    }

    @Override
    public int add(DataInfo dataInfo) {
        dataInfo.setEditTime(new Date());
        return dataInfoDao.add(dataInfo);
    }

    @Override
    public int update(DataInfo dataInfo) {
        dataInfo.setEditTime(new Date());
        return dataInfoDao.update(dataInfo);
    }

    @Override
    public int delete(DataInfo dataInfo) {
        return dataInfoDao.delete(dataInfo);
    }

    @Override
    public List<DataInfo> findByCondition(DataInfo dataInfo) {
        return dataInfoDao.findByCondition(dataInfo);
    }


}
