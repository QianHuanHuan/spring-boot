package com.example.retailers.server.impl;

import com.alibaba.fastjson.JSON;
import com.example.retailers.bean.RetailersUser;
import com.example.retailers.common.RedisRepository;
import com.example.retailers.result.BaseResult;
import com.example.retailers.server.RetailersUserService;
import com.example.retailers.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisRepository repository;

    @Autowired
    RetailersUserService retailersService;

    @Override
    public BaseResult login(RetailersUser retailers) {
        BaseResult baseResult;
        int i = retailersService.findBySingName(retailers.getSignName());

        if (i!=0){
            retailers = retailersService.existentialJudgement(retailers);
            if (retailers == null){
                baseResult = new BaseResult("error","密码错误");
            }else{

                long liveTime = 50000L;
                String json = JSON.toJSONString(retailers);
                repository.set(retailers.getId(),json,liveTime);

                baseResult = new BaseResult("ok","登录成功");
            }
        }else {
            baseResult = new BaseResult("error","用户不存在");
        }
        return baseResult;
    }
}
