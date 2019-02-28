package com.example.retailers.controller;

import com.example.retailers.bean.RetailersUser;
import com.example.retailers.result.BaseResult;
import com.example.retailers.server.RetailersUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/retailersUser")
public class RetailersUserControl {

    @Autowired
    RetailersUserService retailersUserService;

    @GetMapping("/add")
    public BaseResult add(RetailersUser demo){
        return retailersUserService.add(demo);
    }

    @GetMapping("/findRetailersUserById")
    public RetailersUser findRetailersUserById(String id){
        return retailersUserService.find(id);
    }

    @GetMapping("/findRetailersUsers")
    public List<RetailersUser> findRetailersUsers(){
        return retailersUserService.finds();
    }

    @GetMapping("/update")
    public BaseResult update(RetailersUser demo){
        return retailersUserService.update(demo);
    }

    @GetMapping("/delete")
    public BaseResult delete(RetailersUser demo){
        return retailersUserService.delete(demo);
    }
}
