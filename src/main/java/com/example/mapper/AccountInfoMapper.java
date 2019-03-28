package com.example.mapper;

import com.example.model.AccountInfo;
import com.example.model.RoleInfo;
import com.example.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountInfoMapper {
    int deleteByPrimaryKey(Short accountid);

    int insert(AccountInfo record);

    int insertSelective(AccountInfo record);

    AccountInfo selectByPrimaryKey(Short accountid);

    int updateByPrimaryKeySelective(AccountInfo record);

    int updateByPrimaryKey(AccountInfo record);

    AccountInfo selectByAccount(String useraccount);

    //这个方式我自己加的
    List<AccountInfo> selectAll(@Param("filterData") String filterData);

    Integer selectCount(@Param("filterData") String filterData);

    Integer batchDelete(@Param("arr") int[] arr);

    Integer selectOnly(AccountInfo record);

    List<RoleInfo> roleSelect();

    int updateImg(AccountInfo record);
}