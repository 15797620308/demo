package com.example.mapper;

import com.example.model.AccountInfo;
import com.example.model.CourseInfo;
import com.example.model.SelectCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectCourseMapper {
    int deleteByPrimaryKey(Short selid);

    int insert(SelectCourse record);

    int insertSelective(SelectCourse record);

    SelectCourse selectByPrimaryKey(Short selid);

    int updateByPrimaryKeySelective(SelectCourse record);

    int updateByPrimaryKey(SelectCourse record);

    //这个方式我自己加的
    List<SelectCourse> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);

    Integer selectCByTime(@Param("grade") String grade);

    List<SelectCourse> selectByTime(@Param("grade") String grade);
}