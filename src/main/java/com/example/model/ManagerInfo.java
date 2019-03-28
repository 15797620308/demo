package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ManagerInfo {
    private Short manid;

    private String manname;

    private String mansex;

    private Short manage;

    @JSONField(format = "yyyy-MM-dd")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd")   //格式化前台日期参数注解
    private Date mantry;

    private String iswork;

    private String phone;

    public Short getManid() {
        return manid;
    }

    public void setManid(Short manid) {
        this.manid = manid;
    }

    public String getManname() {
        return manname;
    }

    public void setManname(String manname) {
        this.manname = manname == null ? null : manname.trim();
    }

    public String getMansex() {
        return mansex;
    }

    public void setMansex(String mansex) {
        this.mansex = mansex == null ? null : mansex.trim();
    }

    public Short getManage() {
        return manage;
    }

    public void setManage(Short manage) {
        this.manage = manage;
    }

    public Date getMantry() {
        return mantry;
    }

    public void setMantry(Date mantry) {
        this.mantry = mantry;
    }

    public String getIswork() {
        return iswork;
    }

    public void setIswork(String iswork) {
        this.iswork = iswork == null ? null : iswork.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}