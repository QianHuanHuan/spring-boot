package com.example.retailers.dao;

import com.example.retailers.bean.RetailersOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RetailersOrderDao {

    @Select("SELECT * FROM demo_order WHERE id = #{id}")
    RetailersOrder find(@Param("id") String id);

    @Select("SELECT * FROM demo_order ")
    List<RetailersOrder> finds();

    @Insert("INSERT INTO demo_order(id, order_number, user_id, commodity_id, sum, remarks, unit_price) " +
            "VALUES " +
            "(#{demoOrder.id}, #{demoOrder.orderNumber}, #{demoOrder.userId}, #{demoOrder.commodityId}, #{demoOrder.sum}, #{demoOrder.remarks}, #{demoOrder.unitPrice})")
    int add(@Param("demoOrder") RetailersOrder demoOrder);

    @Update("UPDATE demo_order " +
            "SET " +
            "order_number = #{demoOrder.orderNumber}, user_id = #{demoOrder.userId}, commodity_id = #{demoOrder.commodityId}, " +
            "sum = #{demoOrder.sum}, remarks = #{demoOrder.remarks}, unit_price = #{demoOrder.unitPrice} " +
            "WHERE id = #{demoOrder.id}")
    int update(@Param("demoOrder") RetailersOrder demoOrder);

    @Delete("DELETE demo_order WHERE id = #{demoOrder.id}")
    int delete(@Param("demoOrder") RetailersOrder demoOrder);


}
