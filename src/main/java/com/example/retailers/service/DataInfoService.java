package com.example.retailers.service;

import com.example.retailers.bean.DataInfo;

import java.util.List;

public interface DataInfoService {

    DataInfo find(Integer id);
    List<DataInfo> finds();
    int add(DataInfo dataInfo);
    int update(DataInfo dataInfo);
    int delete(DataInfo dataInfo);

    List<DataInfo> findByCondition(DataInfo dataInfo);

}
