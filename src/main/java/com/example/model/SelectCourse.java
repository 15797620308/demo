package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SelectCourse {
    private Short selid;

    private String selname;

    @JSONField(format = "yyyy")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy")   //格式化前台日期参数注解
    private Date selgrade;

    private Short selnum;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")   //格式化前台日期参数注解
    private Date starttime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")   //格式化前台日期参数注解
    private Date endtime;

    private String courseclass;

    private Short synum;

    public Short getSelid() {
        return selid;
    }

    public void setSelid(Short selid) {
        this.selid = selid;
    }

    public String getSelname() {
        return selname;
    }

    public void setSelname(String selname) {
        this.selname = selname == null ? null : selname.trim();
    }

    public Date getSelgrade() {
        return selgrade;
    }

    public void setSelgrade(Date selgrade) {
        this.selgrade = selgrade;
    }

    public Short getSelnum() {
        return selnum;
    }

    public void setSelnum(Short selnum) {
        this.selnum = selnum;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getCourseclass() {
        return courseclass;
    }

    public void setCourseclass(String courseclass) {
        this.courseclass = courseclass == null ? null : courseclass.trim();
    }

    public Short getSynum() {
        return synum;
    }

    public void setSynum(Short synum) {
        this.synum = synum;
    }
}