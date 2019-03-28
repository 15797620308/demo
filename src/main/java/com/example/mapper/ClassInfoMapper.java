package com.example.mapper;

import com.example.model.AccountInfo;
import com.example.model.ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(Short classid);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(Short classid);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);

    //这个方式我自己加的
    List<ClassInfo> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);


}