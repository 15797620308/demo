package com.example.model;

public class SelectResult {
    private Short resid;

    private StudentBase studentBase;

    private SelectCourse selectCourse;

    public Short getResid() {
        return resid;
    }

    public void setResid(Short resid) {
        this.resid = resid;
    }

    public StudentBase getStudentBase() {
        return studentBase;
    }

    public void setStudentBase(StudentBase studentBase) {
        this.studentBase = studentBase;
    }

    public SelectCourse getSelectCourse() {
        return selectCourse;
    }

    public void setSelectCourse(SelectCourse selectCourse) {
        this.selectCourse = selectCourse;
    }
}