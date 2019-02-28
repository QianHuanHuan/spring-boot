package com.example.retailers.common.pageresp;


import java.io.Serializable;
import java.util.List;

/**
 * 分页封装对象
 * @description
 */
public class Pagination<T extends Serializable> extends BasePage implements
        Serializable, Paginable {

    private static final long serialVersionUID = 1L;


    /**
     * 当前页的数据
     */
    private List<T> data;

    public Pagination() {
    }

    public Pagination(int pageNo, int pageSize, long totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    public Pagination(int pageNo, int pageSize, int totalCount, List<T> data) {
        super(pageNo, pageSize, totalCount);
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
