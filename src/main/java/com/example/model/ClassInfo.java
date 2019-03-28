package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ClassInfo {
    private Short classid;

    private String classname;

    @JSONField(format = "yyyy-MM-dd")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd")   //格式化前台日期参数注解
    private Date classtime;

    private String classmajor;

    private Short classnum;

    private TeacherInfo teacherInfo;

    public Short getClassid() {
        return classid;
    }

    public void setClassid(Short classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Date getClasstime() {
        return classtime;
    }

    public void setClasstime(Date classtime) {
        this.classtime = classtime;
    }

    public String getClassmajor() {
        return classmajor;
    }

    public void setClassmajor(String classmajor) {
        this.classmajor = classmajor == null ? null : classmajor.trim();
    }

    public Short getClassnum() {
        return classnum;
    }

    public void setClassnum(Short classnum) {
        this.classnum = classnum;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }
}