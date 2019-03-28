package com.example.service;

import com.example.mapper.*;
import com.example.model.*;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@Service(value = "dataService")
public class DataService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Autowired
    private ManagerInfoMapper managerInfoMapper;
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private StudentBaseMapper studentBaseMapper;
    @Autowired
    private AccountInfoMapper accountInfoMapper;
    @Autowired
    private  CourseInfoMapper courseInfoMapper;
    @Autowired
    private  SelectCourseMapper selectCourseMapper;
    @Autowired
    private  SelectResultMapper selectResultMapper;
    @Autowired
    private  ClassInfoMapper classInfoMapper;
    @Autowired
    private StudentScoreMapper studentScoreMapper;


   //根据用户角色查询用户个人信息
    public Object findData(AccountInfo accountInfo){
        short code = accountInfo.getUsercode();
        String role = accountInfo.getUserrole();
        Object privateData = null;
        if("管理员".equals(role)){
            privateData = managerInfoMapper.selectByPrimaryKey(code);
        }else if("老师".equals(role)){
            privateData = teacherInfoMapper.selectByPrimaryKey(code);
        }else if("学生".equals(role)){
            privateData = studentInfoMapper.selectByPrimaryKey(code);
        }
        return privateData;
    }

    //根据参数获取相应分页数据
    public returnDatas getDatas(int pageNumber, int pageSize, String object, String filterData, HttpSession session){
        returnDatas returnDatas = new returnDatas();
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNumber, pageSize);
        List tabledatas = null;
        Integer countNum = null;
        switch (object){
            case "accountInfo":
               tabledatas = accountInfoMapper.selectAll(filterData);
               countNum = accountInfoMapper.selectCount(filterData);
               break;
            case "managerInfo":
                tabledatas = managerInfoMapper.selectAll(filterData);
                countNum = managerInfoMapper.selectCount(filterData);
                break;
            case "studentBase":
                tabledatas = studentBaseMapper.selectAll(filterData);
                countNum = studentBaseMapper.selectCount(filterData);
                break;
            case "studentInfo":
                tabledatas = studentInfoMapper.selectAll(filterData);
                countNum = studentInfoMapper.selectCount(filterData);
                break;
            case "courseInfo":
                tabledatas = courseInfoMapper.selectAll(filterData);
                countNum = courseInfoMapper.selectCount(filterData);
                break;
            case "seleteCourse":
                AccountInfo accountInfo = (AccountInfo) session.getAttribute("user");
                String role = accountInfo.getUserrole();
                if("学生".equals(role)){
                    short id = accountInfo.getUsercode();
                    Date time = studentInfoMapper.selectByPrimaryKey(id).getStustart();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                    String grade = sdf.format(time)+"%";
                    tabledatas = selectCourseMapper.selectByTime(grade);
                    countNum = selectCourseMapper.selectCByTime(grade);
                }else {
                    tabledatas = selectCourseMapper.selectAll(filterData);
                    countNum = selectCourseMapper.selectCount(filterData);
                }
                break;
            case "teacherInfo":
                tabledatas = teacherInfoMapper.selectAll(filterData);
                countNum = teacherInfoMapper.selectCount(filterData);
                break;
            case "selectResult":
                AccountInfo accountInfo1 = (AccountInfo) session.getAttribute("user");
                String role1 = accountInfo1.getUserrole();
                Short stuid = null;
                if("学生".equals(role1)){
                    short id = accountInfo1.getUsercode();
                    stuid = studentInfoMapper.selectByPrimaryKey(id).getStudentBase().getStuid();
                }
                    tabledatas = selectResultMapper.selectAll(stuid);
                    countNum = selectResultMapper.selectCount(stuid);
                break;
            case "classInfo":
                tabledatas = classInfoMapper.selectAll(filterData);
                countNum = classInfoMapper.selectCount(filterData);
                break;
            case "studentScore":
                AccountInfo accountInfo2 = (AccountInfo) session.getAttribute("user");
                String role2 = accountInfo2.getUserrole();
                if("学生".equals(role2)){
                    short id = accountInfo2.getUsercode();
                    stuid = studentInfoMapper.selectByPrimaryKey(id).getStudentBase().getStuid();
                    tabledatas = studentScoreMapper.selectByStuId(stuid);
                    countNum = studentScoreMapper.selectCBySyuId(stuid);
                }else {
                    tabledatas = studentScoreMapper.selectAll(filterData);
                    countNum = studentScoreMapper.selectCount(filterData);
                }
                break;
        }
        returnDatas.setTabledatas(tabledatas);
        returnDatas.setCountNum(countNum);
        return returnDatas;
    }

    //根据删除
    public int deldata(String object,Short id){
        int result = 0;
        switch (object){
            case "accountInfo":
                result = accountInfoMapper.deleteByPrimaryKey(id);
                break;
            case "managerInfo":
                result = managerInfoMapper.deleteByPrimaryKey(id);
                break;
            case "studentBase":
                result = studentBaseMapper.deleteByPrimaryKey(id);
                break;
            case "studentInfo":
                result = studentInfoMapper.deleteByPrimaryKey(id);
                break;
            case "courseInfo":
                result = courseInfoMapper.deleteByPrimaryKey(id);
                break;
            case "selectCourse":
                result = selectCourseMapper.deleteByPrimaryKey(id);
                selectResultMapper.deleteByselId(id);
                break;
            case "teacherInfo":
                result = teacherInfoMapper.deleteByPrimaryKey(id);
                break;
            case "selectResult":
                result = selectResultMapper.deleteByPrimaryKey(id);
                break;
            case "classInfo":
                result = classInfoMapper.deleteByPrimaryKey(id);
                break;
            case "studentScore":
                result = studentScoreMapper.deleteByPrimaryKey(id);
                break;
        }
        return result;
    }

    //批量删除
    public boolean batchDelete(String object,int[] arr) throws Exception{
        SqlSession batchSqlSeeeion  = null;
        int result = 0;
        try{
            // 获取批量方式的sqlsession
            batchSqlSeeeion = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
            switch (object){
                case "accountInfo":
                    AccountInfoMapper newAccountInfo= batchSqlSeeeion.getMapper(AccountInfoMapper.class);
                    result = newAccountInfo.batchDelete(arr);
                    break;
                case "managerInfo":
                    ManagerInfoMapper managerInfoMapper1= batchSqlSeeeion.getMapper(ManagerInfoMapper.class);
                    result = managerInfoMapper1.batchDelete(arr);
                    break;
                case "studentBase":
                    StudentBaseMapper studentBaseMapper1= batchSqlSeeeion.getMapper(StudentBaseMapper.class);
                    result = studentBaseMapper1.batchDelete(arr);
                    break;
                case "studentInfo":
                    StudentInfoMapper studentInfoMapper1= batchSqlSeeeion.getMapper(StudentInfoMapper.class);
                    result = studentInfoMapper1.batchDelete(arr);
                    break;
                case "courseInfo":
                    CourseInfoMapper courseInfoMapper1= batchSqlSeeeion.getMapper(CourseInfoMapper.class);
                    result = courseInfoMapper1.batchDelete(arr);
                    break;
                case "seleteCourse":
                    SelectCourseMapper selectCourseMapper1= batchSqlSeeeion.getMapper(SelectCourseMapper.class);
                    result = selectCourseMapper1.batchDelete(arr);
                    break;
                case "teacherInfo":
                    TeacherInfoMapper teacherInfoMapper1= batchSqlSeeeion.getMapper(TeacherInfoMapper.class);
                    result = teacherInfoMapper1.batchDelete(arr);
                    break;
                case "selectResult":
                    SelectResultMapper selectResultMapper1= batchSqlSeeeion.getMapper(SelectResultMapper.class);
                    result = selectResultMapper1.batchDelete(arr);
                    break;
                case "classInfo":
                    ClassInfoMapper classInfoMapper1= batchSqlSeeeion.getMapper(ClassInfoMapper.class);
                    result = classInfoMapper1.batchDelete(arr);
                    break;
                case "studentScore":
                    StudentScoreMapper studentScoreMapper1= batchSqlSeeeion.getMapper(StudentScoreMapper.class);
                    result = studentScoreMapper1.batchDelete(arr);
                    break;
            }
            batchSqlSeeeion.commit();
            batchSqlSeeeion.clearCache();
        }catch (Exception e){
            batchSqlSeeeion.rollback();
            e.printStackTrace();
        }finally {
            batchSqlSeeeion.close();
        }
        return true;
    }

    //账号管理修改
    public boolean accountInfo(String postWay, AccountInfo accountInfo){
        if("add".equals(postWay)){
            String role = accountInfo.getUserrole();
            short key = accountInfo.getUsercode();
            Object account = null;
            if("管理员".equals(role)){
                account = managerInfoMapper.selectByPrimaryKey(key);
            }else if("学生".equals(role)){
                account = studentInfoMapper.selectByPrimaryKey(key);
            }else if("老师".equals(role)){
                account = teacherInfoMapper.selectByPrimaryKey(key);
            }
            if(account==null){
                return false;
            }
            accountInfo.setUserpwd("123456");
            accountInfoMapper.insertSelective(accountInfo);
            return true;
        }else{
            accountInfoMapper.updateByPrimaryKeySelective(accountInfo);
            return true;
        }

    }

    //管理员信息
    public boolean managerInfo(String postWay, ManagerInfo managerInfo){
        if("add".equals(postWay)){
            managerInfoMapper.insertSelective(managerInfo);
            return true;
        }else{
            managerInfoMapper.updateByPrimaryKeySelective(managerInfo);
            return true;
        }

    }

    //学生基本信息
    public boolean studentBase(String postWay, StudentBase studentBase){
        if("add".equals(postWay)){
            studentBaseMapper.insertSelective(studentBase);
            return true;
        }else{
            studentBaseMapper.updateByPrimaryKeySelective(studentBase);
            return true;
        }

    }

    //学生信息
    public boolean studentInfo(String postWay, StudentInfo studentInfo){
        if("add".equals(postWay)){
            studentInfoMapper.insertSelective(studentInfo);
            return true;
        }else{
            studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
            return true;
        }
    }

    //课程信息
    public boolean courseInfo(String postWay, CourseInfo courseInfo){
        if("add".equals(postWay)){
            courseInfoMapper.insertSelective(courseInfo);
            return true;
        }else{
            courseInfoMapper.updateByPrimaryKeySelective(courseInfo);
            return true;
        }
    }

    //选课信息
    public boolean selectCourse(String postWay, SelectCourse selectCourse){
        if("add".equals(postWay)){
            selectCourse.setSynum(selectCourse.getSelnum());
            selectCourseMapper.insertSelective(selectCourse);
            return true;
        }else{
            selectCourseMapper.updateByPrimaryKeySelective(selectCourse);
            return true;
        }
    }

    //老师信息
    public boolean teacherInfo(String postWay, TeacherInfo teacherInfo){
        if("add".equals(postWay)){
            teacherInfoMapper.insertSelective(teacherInfo);
            return true;
        }else{
            teacherInfoMapper.updateByPrimaryKeySelective(teacherInfo);
            return true;
        }
    }

    //选课结果信息
    public boolean selectResult(String postWay, SelectResult selectResult){
        if("add".equals(postWay)){
            selectResultMapper.insertSelective(selectResult);
            return true;
        }else{
            selectResultMapper.updateByPrimaryKeySelective(selectResult);
            return true;
        }
    }

    //班级信息
    public boolean classInfo(String postWay, ClassInfo classInfo){
        if("add".equals(postWay)){
            classInfoMapper.insertSelective(classInfo);
            return true;
        }else{
            classInfoMapper.updateByPrimaryKeySelective(classInfo);
            return true;
        }
    }

    //学生成绩
    public boolean studentScore(String postWay, StudentScore studentScore){
        if("add".equals(postWay)){
            double score = studentScore.getStuscore();
            if(score<60){
                studentScore.setIspass("挂科");
            }else{
                studentScore.setIspass("通过");
            }
            studentScoreMapper.insertSelective(studentScore);
            return true;
        }else{
            studentScoreMapper.updateByPrimaryKeySelective(studentScore);
            return true;
        }
    }

    public int select(short id,HttpSession session){
        AccountInfo accountInfo = (AccountInfo) session.getAttribute("user");
        short stuId = accountInfo.getUsercode();
        StudentBase studentBase = studentInfoMapper.selectByPrimaryKey(stuId).getStudentBase();
        SelectCourse selectCourse = selectCourseMapper.selectByPrimaryKey(id);
        SelectResult selectResult = new SelectResult();
        selectResult.setSelectCourse(selectCourse);
        selectResult.setStudentBase(studentBase);
        SelectResult selectResult1 = selectResultMapper.selectByselId(selectResult);
        int result = 2;
        if(selectResult1==null){
            short num = selectCourse.getSynum();
            result = 3;
            if(num>0){
                result = selectResultMapper.insertSelective(selectResult);
                num = (short)(num - 1);
                selectCourse.setSynum(num);
                selectCourseMapper.updateByPrimaryKeySelective(selectCourse);
            }

        }

        return result;
    }

    public Map stuforSelect(){
       List<StudentBase> studentBaseList= studentBaseMapper.selectAll(null);
       List<ClassInfo> classInfoList =  classInfoMapper.selectAll(null);
       List<TeacherInfo> teacherInfoList =  teacherInfoMapper.selectAll(null);
        Map map = new HashMap();
        map.put("studentBaseList",studentBaseList);
        map.put("classInfoList",classInfoList);
        map.put("teacherInfoList",teacherInfoList);
        return map;
    }

    public int init(int[] arr){
        SqlSession batchSqlSeeeion  = null;
        int result = 0;
        // 获取批量方式的sqlsession
        batchSqlSeeeion = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
        AccountInfoMapper accountInfoMapper1 = batchSqlSeeeion.getMapper(AccountInfoMapper.class);
        try {
            for (int i = 0; i < arr.length; i++) {
                AccountInfo accountInfo = new AccountInfo();
                accountInfo.setAccountid((short)arr[i]);
                accountInfo.setUserpwd("123456");
                accountInfoMapper1.updateByPrimaryKeySelective(accountInfo);
            }
        batchSqlSeeeion.commit();
        batchSqlSeeeion.clearCache();
    }catch (Exception e){
        result = 1;
        batchSqlSeeeion.rollback();
        e.printStackTrace();
    }finally {
        batchSqlSeeeion.close();
    }
        return result;
    }

    public List<RoleInfo> roleSelect(){
        List<RoleInfo> roleInfo = accountInfoMapper.roleSelect();
        return roleInfo;
    }

    public int chageImg(AccountInfo accountInfo){
        int result = accountInfoMapper.updateImg(accountInfo);
        return result;
    }
}
