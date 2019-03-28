package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentInfo {
    private Short stuid;

    private StudentBase studentBase;

    private ClassInfo classInfo;

    @JSONField(format = "yyyy-MM-dd")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd")   //格式化前台日期参数注解
    private Date stustart;

    private String phone;

    private TeacherInfo teacherInfo;

    private String stumajor;

    public StudentBase getStudentBase() {
        return studentBase;
    }

    public void setStudentBase(StudentBase studentBase) {
        this.studentBase = studentBase;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public Short getStuid() {
        return stuid;
    }

    public void setStuid(Short stuid) {
        this.stuid = stuid;
    }

    public Date getStustart() {
        return stustart;
    }

    public void setStustart(Date stustart) {
        this.stustart = stustart;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getStumajor() {
        return stumajor;
    }

    public void setStumajor(String stumajor) {
        this.stumajor = stumajor == null ? null : stumajor.trim();
    }
}