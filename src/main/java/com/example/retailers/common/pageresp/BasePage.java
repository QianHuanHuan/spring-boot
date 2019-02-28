package com.example.retailers.common.pageresp;

import lombok.Data;

/**
 * @description
 */
@Data
public class BasePage implements Paginable {


    public static final int DEF_COUNT = 10;

    protected long count = 0;

    protected int itemsPerPage = DEF_COUNT;

    protected int currentPage = 1;

    protected int totalPage = 1;

    public BasePage() {
    }

    public BasePage(int pageNo, int pageSize, long totalCount) {
        if (totalCount <= 0) {
            this.count = 0;
        } else {
            this.count = totalCount;
        }
        if (pageSize <= 0) {
            this.itemsPerPage = DEF_COUNT;
        } else {
            this.itemsPerPage = pageSize;
        }
        if (pageNo <= 0) {
            this.currentPage = 1;
        } else {
            this.currentPage = pageNo;
        }
        if ((this.currentPage - 1) * this.itemsPerPage >= totalCount) {
            if (this.count / this.itemsPerPage == 0) {
                this.currentPage = 1;
            } else {
                this.currentPage = (int)this.count / this.itemsPerPage;
            }
        }
    }

    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public int getItemsPerPage() {
        return itemsPerPage;
    }

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public int getTotalPage() {
        int totalPage = (int) count / itemsPerPage;
        if (count % itemsPerPage != 0 || totalPage == 0) {
            totalPage++;
        }
        return totalPage;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setItemsPerPage(int pageSize) {
        this.itemsPerPage = pageSize;
    }

    public void setCurrentPage(int pageNo) {
        this.currentPage = pageNo;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
