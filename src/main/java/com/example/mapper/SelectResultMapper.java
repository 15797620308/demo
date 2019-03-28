package com.example.mapper;

import com.example.model.SelectCourse;
import com.example.model.SelectResult;
import com.example.model.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectResultMapper {
    int deleteByPrimaryKey(Short resid);

    int insert(SelectResult record);

    int insertSelective(SelectResult record);

    SelectResult selectByPrimaryKey(Short resid);

    int updateByPrimaryKeySelective(SelectResult record);

    int updateByPrimaryKey(SelectResult record);

    //这个方式我自己加的
    List<SelectResult> selectAll(@Param("stuId") Short stuId);

    Integer selectCount(@Param("stuId") Short stuId);

    Integer batchDelete(@Param("arr") int[] arr);

    Integer deleteByselId(@Param("resid") short resid);

    SelectResult selectByselId(SelectResult record);

}