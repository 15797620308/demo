package com.example.mapper;

import com.example.model.SelectResult;
import com.example.model.StudentScore;
import com.example.model.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentScoreMapper {
    int deleteByPrimaryKey(Short scoreid);

    int insert(StudentScore record);

    int insertSelective(StudentScore record);

    StudentScore selectByPrimaryKey(Short scoreid);

    int updateByPrimaryKeySelective(StudentScore record);

    int updateByPrimaryKey(StudentScore record);

    //这个方式我自己加的
    List<StudentScore> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);

    List<StudentScore> selectByStuId(@Param("stuId") Short stuId);

    Integer selectCBySyuId(@Param("stuId") Short stuId);
}