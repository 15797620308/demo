package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.mapper.StudentInfoMapper;
import com.example.model.Navs;
import com.example.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class test {
        @Autowired
        StudentInfoMapper studentInfoMapper;
    public static void main(String[] args){
        StudentInfoMapper studentInfoMapper = null;
        StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey((short) 1);
        String stuname = studentInfo.getStudentBase().getStuname();
        String className = studentInfo.getClassInfo().getClassname();
        String teachername = studentInfo.getTeacherInfo().getTeachname();
        System.out.println(stuname);
        System.out.println(className);
        System.out.println(teachername);
    }
}
