package com.example.retailers.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController(value = "/data")
public class DataController {

    @GetMapping("/findCode")
    @ApiOperation(value = "刘辟 的  形象哦")
    public List<Map<String,Object>> findCode(){
        List<Map<String,Object>>  list  =  new ArrayList<>();
        Map<String,Object> m1  =    new HashMap<>();
        Map<String,Object> m2  =    new HashMap<>();
        Map<String,Object> m3  =    new HashMap<>();
        m1.put("name","按时到岗  ");
        m1.put("age","666");
        m2.put("name","asdh  ");
        m2.put("age","asdgh");
        m3.put("name","阿士大夫和  ");
        m3.put("age","asdh");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        return list;
    }

}
