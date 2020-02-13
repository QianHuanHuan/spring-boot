package com.example.retailers.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class DataInfo implements Serializable {

    @Id
    private Integer id;
    @Column(name="key")
    private String key;
    @Column(name="value")
    private String value;
    @Column(name="data_flag")
    private String dataFlag;
    @Column(name="type")
    private String type;
    @Column(name="edit_time")
    private Date editTime;

    private String noTime;

    public String getNoTime() {
        if(editTime == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(editTime);
    }

    public void setNoTime(String noTime) {
        this.noTime = noTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }


}
