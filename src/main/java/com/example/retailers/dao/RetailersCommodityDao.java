package com.example.retailers.dao;

import com.example.retailers.bean.RetailersCommodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RetailersCommodityDao {

    @Select("SELECT * FROM retailers_commodity WHERE id = #{id}")
    RetailersCommodity find(@Param("id") String id);

    @Select("SELECT * FROM retailers_commodity ")
    List<RetailersCommodity> finds();

    @Insert("INSERT INTO retailers_commodity(id, name, price, stock) " +
            "VALUES " +
            "(#{retailersCommodity.id}, #{retailersCommodity.name}, #{retailersCommodity.price}, #{retailersCommodity.stock})")
    int add(@Param("retailersCommodity") RetailersCommodity retailersCommodity);

    @Update("UPDATE retailers_commodity " +
            "SET " +
            "name = #{retailersCommodity.name}, price = #{retailersCommodity.price}, stock = #{retailersCommodity.stock} " +
            "WHERE id = #{retailersCommodity.id}")
    int update(@Param("retailersCommodity") RetailersCommodity retailersCommodity);

    @Delete("DELETE retailers_commodity WHERE id = #{retailersCommodity.id}")
    int delete(@Param("retailersCommodity") RetailersCommodity retailersCommodity);
}
