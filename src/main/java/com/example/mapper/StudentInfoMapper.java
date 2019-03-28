package com.example.mapper;

import com.example.model.AccountInfo;
import com.example.model.StudentInfo;
import com.example.model.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(Short stuid);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(Short stuid);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);

    //这个方式我自己加的
    List<StudentInfo> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);
}