package com.example.mapper;

import com.example.model.AccountInfo;
import com.example.model.CourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(Short courseid);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(Short courseid);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);

    //这个方式我自己加的
    List<CourseInfo> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);
}