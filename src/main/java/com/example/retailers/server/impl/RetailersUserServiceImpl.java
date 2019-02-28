package com.example.retailers.server.impl;

import com.example.retailers.bean.RetailersUser;
import com.example.retailers.dao.RetailersUserDao;
import com.example.retailers.result.BaseResult;
import com.example.retailers.server.RetailersUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailersUserServiceImpl implements RetailersUserService {

    @Autowired
    RetailersUserDao dao ;

    @Override
    public BaseResult add(RetailersUser retailers) {
        return BaseResult.findBaseResult(dao.add(retailers));
    }

    @Override
    public RetailersUser find(String id) {
        return dao.find(id);
    }

    @Override
    public List<RetailersUser> finds() {
        return dao.finds();
    }

    @Override
    public BaseResult update(RetailersUser retailers) {
        return BaseResult.findBaseResult(dao.update(retailers));
    }

    @Override
    public BaseResult delete(RetailersUser retailers) {
        return BaseResult.findBaseResult(dao.delete(retailers));
    }

    @Override
    public int findBySingName(String signName){
        return dao.findBySingName(signName);
    }

    @Override
    public RetailersUser existentialJudgement(RetailersUser retailers){
        return dao.existentialJudgement(retailers);
    }

}
