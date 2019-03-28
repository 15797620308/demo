package com.example.controller;

import com.example.model.*;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/addEdit")
public class AddEditController {

    @Autowired
    private DataService dataService;

    @ResponseBody
    @RequestMapping(value = "/accountInfo",produces = {"application/json;charset=UTF-8"})
    public boolean accountInfo(String postWay, AccountInfo accountInfo){
        boolean result = dataService.accountInfo(postWay,accountInfo);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/managerInfo",produces = {"application/json;charset=UTF-8"})
    public boolean managerInfo(String postWay, ManagerInfo managerInfo){
        boolean result = dataService.managerInfo(postWay,managerInfo);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/studentBase",produces = {"application/json;charset=UTF-8"})
    public boolean studentBase(String postWay, StudentBase studentBase){
        boolean result = dataService.studentBase(postWay,studentBase);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/studentInfo",produces = {"application/json;charset=UTF-8"})
    public boolean studentInfo(String postWay, StudentInfo studentInfo){
        boolean result = dataService.studentInfo(postWay,studentInfo);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/courseInfo",produces = {"application/json;charset=UTF-8"})
    public boolean courseInfo(String postWay, CourseInfo courseInfo){
        boolean result = dataService.courseInfo(postWay,courseInfo);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/selectCourse",produces = {"application/json;charset=UTF-8"})
    public boolean selectCourse(String postWay, SelectCourse selectCourse){
        boolean result = dataService.selectCourse(postWay,selectCourse);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/teacherInfo",produces = {"application/json;charset=UTF-8"})
    public boolean teacherInfo(String postWay, TeacherInfo teacherInfo){
        boolean result = dataService.teacherInfo(postWay,teacherInfo);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/selectResult",produces = {"application/json;charset=UTF-8"})
    public boolean selectResult(String postWay, SelectResult selectResult){
        boolean result = dataService.selectResult(postWay,selectResult);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/classInfo",produces = {"application/json;charset=UTF-8"})
    public boolean classInfo(String postWay, ClassInfo classInfo){
        boolean result = dataService.classInfo(postWay,classInfo);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/studentScore",produces = {"application/json;charset=UTF-8"})
    public boolean studentScore(String postWay, StudentScore studentScore){
        boolean result = dataService.studentScore(postWay,studentScore);
        return result;
    }

}
