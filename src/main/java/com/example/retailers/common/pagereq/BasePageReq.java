package com.example.retailers.common.pagereq;

import lombok.Data;

import java.io.Serializable;

/**
 * 基本的分页查询
 */
@Data
public class BasePageReq implements Serializable {

    /**
     * 当前页码数
     */
    private Integer currentPage = 1;

    /**
     * 每页条数
     */
    private Integer itemsPerPage = 10;

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public Integer getCurrentPage() {

        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
