package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CourseInfo {
    private Short courseid;

    private String coursename;

    private Short coursetime;

    @JSONField(format = "yyyy")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy")   //格式化前台日期参数注解
    private Date grade;

    public Short getCourseid() {
        return courseid;
    }

    public void setCourseid(Short courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public Short getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(Short coursetime) {
        this.coursetime = coursetime;
    }

    public Date getGrade() {
        return grade;
    }

    public void setGrade(Date grade) {
        this.grade = grade;
    }
}