package com.example.mapper;

import com.example.model.AccountInfo;
import com.example.model.StudentBase;
import com.example.model.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentBaseMapper {
    int deleteByPrimaryKey(Short stuid);

    int insert(StudentBase record);

    int insertSelective(StudentBase record);

    StudentBase selectByPrimaryKey(Short stuid);

    int updateByPrimaryKeySelective(StudentBase record);

    int updateByPrimaryKey(StudentBase record);

    //这个方式我自己加的
    List<StudentBase> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);
}