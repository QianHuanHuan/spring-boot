package com.example.retailers.dao;

import com.example.retailers.bean.RetailersOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RetailersOrderDao {

    @Select("SELECT * FROM retailers_order WHERE id = #{id}")
    RetailersOrder find(@Param("id") String id);

    @Select("SELECT * FROM retailers_order ")
    List<RetailersOrder> finds();

    @Insert("INSERT INTO retailers_order(id, order_number, user_id, commodity_id, sum, remarks, unit_price) " +
            "VALUES " +
            "(#{retailersOrder.id}, #{retailersOrder.orderNumber}, #{retailersOrder.userId}, #{retailersOrder.commodityId}, #{retailersOrder.sum}, #{retailersOrder.remarks}, #{retailersOrder.unitPrice})")
    int add(@Param("retailersOrder") RetailersOrder retailersOrder);

    @Update("UPDATE retailers_order " +
            "SET " +
            "order_number = #{retailersOrder.orderNumber}, user_id = #{retailersOrder.userId}, commodity_id = #{retailersOrder.commodityId}, " +
            "sum = #{retailersOrder.sum}, remarks = #{retailersOrder.remarks}, unit_price = #{retailersOrder.unitPrice} " +
            "WHERE id = #{retailersOrder.id}")
    int update(@Param("retailersOrder") RetailersOrder retailersOrder);

    @Delete("DELETE retailers_order WHERE id = #{retailersOrder.id}")
    int delete(@Param("retailersOrder") RetailersOrder retailersOrder);


}
