package com.example.mapper;


import com.example.model.AccountInfo;
import com.example.model.ManagerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerInfoMapper {
    int deleteByPrimaryKey(Short manid);

    int insert(ManagerInfo record);

    int insertSelective(ManagerInfo record);

    ManagerInfo selectByPrimaryKey(Short manid);

    int updateByPrimaryKeySelective(ManagerInfo record);

    int updateByPrimaryKey(ManagerInfo record);

    //这个方式我自己加的
    List<ManagerInfo> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);
}