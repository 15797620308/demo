package com.example.mapper;

import com.example.model.AccountInfo;
import com.example.model.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherInfoMapper {
    int deleteByPrimaryKey(Short teachid);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(Short teachid);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);

    //这个方式我自己加的
    List<TeacherInfo> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);
}