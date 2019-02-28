package com.example.retailers.dao;

import com.example.retailers.bean.RetailersUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RetailersUserDao {

    /**
     * 插入retailersUser
     * @param retailersUser
     * @return
     */
    @Insert("INSERT INTO retailers_user( user_name, sign_name, pass_word, gender, age, introduction) " +
            "VALUES " +
            "(#{retailersUser.userName}, #{retailersUser.signName}, #{retailersUser.passWord}, #{retailersUser.gender}, #{retailersUser.age}, #{retailersUser.introduction})")
    int add(@Param("retailersUser") RetailersUser retailersUser);

    @Select("SELECT * FROM retailersUser d WHERE d.id = #{id}")
    RetailersUser find(@Param("id") String id);

    /**
     * 查询列表
     * @return
     */
    @Select("SELECT * FROM retailers_user")
    List<RetailersUser> finds();

    /**
     * 修改
     * @param retailersUser
     * @return
     */
    @Update("UPDATE retailers_user SET user_name = #{retailersUser.userName} , sign_name = #{retailersUser.signName},pass_word = #{retailersUser.passWord}, " +
            "gender = #{retailersUser.gender} , age = #{retailersUser.age} , introduction = #{retailersUser.introduction} " +
            "WHERE id = #{retailersUser.id}")
    int update(@Param("retailersUser") RetailersUser retailersUser);

    /**
     * 删除
     * @param retailersUser
     * @return
     */
    @Delete("DELETE retailers_user WHERE id = #{retailersUser.id} ")
    int delete(@Param("retailersUser") RetailersUser retailersUser);

    /**
     * 获取登录用户信息
     * @param retailersUser
     * @return
     */
    @Select("SELECT * FROM retailers_user WHERE sign_name = #{retailersUser.signName} AND pass_word = #{retailersUser.passWord}")
    RetailersUser existentialJudgement(@Param("retailersUser") RetailersUser retailersUser);

    /**
     * 获取用户是否存在
     * @param signName
     * @return
     */
    @Select("SELECT COUNT(0) FROM retailers_user WHERE sign_name = #{signName}")
    int findBySingName(@Param("signName") String signName);

}
