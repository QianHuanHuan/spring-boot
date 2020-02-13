package com.example.retailers.controller;


import com.example.retailers.bean.DataInfo;
import com.example.retailers.service.DataInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/dataInfo")
@RequestMapping("/dataInfo")
public class DataInfoController {

    @Autowired
    DataInfoService dataInfoService;

    @GetMapping("/find")
    @ApiOperation(value = "id查询数据 ")
    public DataInfo find(Integer id){
        return dataInfoService.find(id);
    }

    @GetMapping("/finds")
    @ApiOperation(value = "获取  列表  ")
    public List<DataInfo> finds(){
        return dataInfoService.finds();
    }

    @GetMapping("/add")
    @ApiOperation(value = "添加数据条件 ")
    public int add(DataInfo dataInfo){
        return dataInfoService.add(dataInfo);
    }

    @GetMapping("/update")
    @ApiOperation(value = "修改数据 ")
    public int update(DataInfo dataInfo){
        return dataInfoService.update(dataInfo);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除数据  ")
    public int delete(DataInfo dataInfo){
        return dataInfoService.delete(dataInfo);
    }

    @GetMapping("/findByCondition")
    @ApiOperation(value = "条件查询")
    public List<DataInfo> findByCondition(DataInfo dataInfo){
        return dataInfoService.findByCondition(dataInfo);
    }

}
