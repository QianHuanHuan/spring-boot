package com.example.retailers.server;

import com.example.retailers.bean.RetailersUser;
import com.example.retailers.result.BaseResult;

public interface UserService {

    BaseResult login(RetailersUser demo);

}
