package com.example.demo;

import com.example.mapper.StudentInfoMapper;
import com.example.model.StudentInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test extends DemoApplicationTests{
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Test
    public void studentTest(){
        StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey((short) 1);
        String stuname = studentInfo.getStudentBase().getStuname();
        String className = studentInfo.getClassInfo().getClassname();
        String teachername = studentInfo.getTeacherInfo().getTeachname();
        System.out.println(stuname);
        System.out.println(className);
        System.out.println(teachername);
    }
}
