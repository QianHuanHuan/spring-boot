package com.example.retailers.common.consts;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInformation implements Serializable {

    private String userId;//用户ID
    private String commodityId;//商品ID
    private int sum;//下单数量
    private double discount;//折扣

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
