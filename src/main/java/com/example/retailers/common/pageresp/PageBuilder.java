package com.example.retailers.common.pageresp;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 构建分页结果
 * @description
 */
public class PageBuilder<T extends Serializable> implements Serializable{


    /**
     * 构建分页结果
     * @param page
     * @param list
     * @return
     */
    public static<T> Pagination buildPageResult(Page<Object> page, List<T> list){
        Pagination pagination = new Pagination();
        pagination.setData(list);
        pagination.setCount(page.getTotal());
        pagination.setItemsPerPage(page.getPageSize());
        pagination.setCurrentPage(page.getPageNum());
        pagination.setTotalPage(page.getPages());
        return pagination;
    }


}
