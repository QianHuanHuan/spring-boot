package com.example.retailers.dao;

import com.example.retailers.bean.DataInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DataInfoDao {

    @Select("SELECT * FROM data_info WHERE data_info.id = #{id}")
    DataInfo find(@Param("id") Integer id);

    @Select("SELECT * FROM data_info ")
    List<DataInfo> finds();

    @Insert("insert into `data_info`( data_info.key, data_info.value, data_info.type, data_info.edit_time)" +
            " VALUES ( #{dataInfo.key}, #{dataInfo.value}, #{dataInfo.type}, #{dataInfo.editTime}) ")
    //INSERT INTO retailers.data_info(id, key, value, data_flag, type, edit_time) VALUES (1, 'U1', '开启考试', 'I', 'T', '2020-02-13');
    int add(@Param("dataInfo") DataInfo dataInfo);

    @Update("UPDATE `data_info` SET " +
            "data_info.key = #{dataInfo.key}, data_info.value = #{dataInfo.value}, data_info.data_flag = #{dataInfo.dataFlag}, " +
            "data_info.type = #{dataInfo.type}, data_info.edit_time = #{dataInfo.editTime} " +
            "WHERE data_info.id = #{dataInfo.id} ")
    //UPDATE retailers.data_info SET key = 'U1', value = '开启考试', data_flag = 'I', type = 'T', edit_time = '2020-02-13' WHERE id = 1;
    int update(@Param("dataInfo") DataInfo dataInfo);

    @Delete("DELETE `data_info` WHERE data_info.id = #{dataInfo.id}")
    int delete(@Param("dataInfo")  DataInfo dataInfo);

    @Select("<script> " +
            "SELECT * FROM `data_info` where 1  = 1   " +
            "<if test='dataInfo.key != null'> " +
            "AND data_info.key = #{dataInfo.key} "+
            "</if> " +
            "<if test='dataInfo.value != null'> " +
            "AND data_info.value = #{dataInfo.value} "+
            "</if> " +
            "<if test='dataInfo.type != null'> " +
            "AND data_info.type = #{dataInfo.type} "+
            "</if> " +
            "</script>")
    List<DataInfo> findByCondition(@Param("dataInfo") DataInfo dataInfo);

}
