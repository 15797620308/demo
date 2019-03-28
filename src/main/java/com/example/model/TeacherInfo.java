package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TeacherInfo {
    private Short teachid;

    private String teachname;

    private String teachsex;

    private Short teachage;

    @JSONField(format = "yyyy-MM-dd")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd")   //格式化前台日期参数注解
    private Date mantry;

    private String iswork;

    private String phone;

    private String position;

    public Short getTeachid() {
        return teachid;
    }

    public void setTeachid(Short teachid) {
        this.teachid = teachid;
    }

    public String getTeachname() {
        return teachname;
    }

    public void setTeachname(String teachname) {
        this.teachname = teachname == null ? null : teachname.trim();
    }

    public String getTeachsex() {
        return teachsex;
    }

    public void setTeachsex(String teachsex) {
        this.teachsex = teachsex == null ? null : teachsex.trim();
    }

    public Short getTeachage() {
        return teachage;
    }

    public void setTeachage(Short teachage) {
        this.teachage = teachage;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }
}