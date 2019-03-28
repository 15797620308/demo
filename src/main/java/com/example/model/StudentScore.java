package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentScore {
    private Short scoreid;

    private StudentBase studentBase;

    private ClassInfo classInfo;

    private Double stuscore;

    @JSONField(format = "yyyy-MM-dd")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd")   //格式化前台日期参数注解
    private Date testtime;

    private String ispass;

    private TeacherInfo teacherInfo;

    public Short getScoreid() {
        return scoreid;
    }

    public void setScoreid(Short scoreid) {
        this.scoreid = scoreid;
    }



    public Double getStuscore() {
        return stuscore;
    }

    public void setStuscore(Double stuscore) {
        this.stuscore = stuscore;
    }

    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    public String getIspass() {
        return ispass;
    }

    public void setIspass(String ispass) {
        this.ispass = ispass == null ? null : ispass.trim();
    }

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
}