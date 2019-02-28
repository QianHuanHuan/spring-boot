package com.example.retailers.server;

import com.example.retailers.bean.RetailersUser;
import com.example.retailers.result.BaseResult;

import java.util.List;

public interface RetailersUserService {

    BaseResult add(RetailersUser retailersUser);
    RetailersUser find(String id);
    List<RetailersUser> finds();
    BaseResult update(RetailersUser retailersUser);
    BaseResult delete(RetailersUser retailersUser);
    int findBySingName(String signName);
    RetailersUser existentialJudgement(RetailersUser retailersUser);
}
