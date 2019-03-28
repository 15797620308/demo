package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentBase {
    private Short stuid;

    private String stuname;

    private String stusex;

    @JSONField(format = "yyyy-MM-dd")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd")   //格式化前台日期参数注解
    private Date stubrith;

    private String stufamily;

    private String stuaddress;

    private String stunation;

    public Short getStuid() {
        return stuid;
    }

    public void setStuid(Short stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex == null ? null : stusex.trim();
    }

    public Date getStubrith() {
        return stubrith;
    }

    public void setStubrith(Date stubrith) {
        this.stubrith = stubrith;
    }

    public String getStufamily() {
        return stufamily;
    }

    public void setStufamily(String stufamily) {
        this.stufamily = stufamily == null ? null : stufamily.trim();
    }

    public String getStuaddress() {
        return stuaddress;
    }

    public void setStuaddress(String stuaddress) {
        this.stuaddress = stuaddress == null ? null : stuaddress.trim();
    }

    public String getStunation() {
        return stunation;
    }

    public void setStunation(String stunation) {
        this.stunation = stunation == null ? null : stunation.trim();
    }
}