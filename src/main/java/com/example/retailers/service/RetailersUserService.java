package com.example.retailers.service;

import com.example.retailers.bean.RetailersUser;
import com.example.retailers.result.BaseResult;

import java.util.List;

public interface RetailersUserService {

    BaseResult add(RetailersUser retailersUser);
    RetailersUser find(String id);
    List<RetailersUser> finds();
    BaseResult update(RetailersUser retailersUser);
    BaseResult delete(RetailersUser retailersUser);

    /**
     * 判断登录名是否存在
     * @param signName
     * @return
     */
    int findBySingName(String signName);

    /**
     * 获取登录用户信息
     * @param retailersUser
     * @return
     */
    RetailersUser existentialJudgement(RetailersUser retailersUser);
}
