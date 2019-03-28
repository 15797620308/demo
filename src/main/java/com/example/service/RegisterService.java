package com.example.service;

import com.example.mapper.AccountInfoMapper;
import com.example.mapper.ManagerInfoMapper;
import com.example.mapper.StudentInfoMapper;
import com.example.mapper.TeacherInfoMapper;
import com.example.model.AccountInfo;
import com.example.model.ManagerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "registerService")
public class RegisterService {

    @Autowired
    private ManagerInfoMapper managerInfoMapper;
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private AccountInfoMapper accountInfoMapper;

    public boolean saveAccount(AccountInfo accountInfo){
        String role = accountInfo.getUserrole();
        short key = accountInfo.getUsercode();
        Object account = null;
        if("管理员".equals(role)){
            account = managerInfoMapper.selectByPrimaryKey(key);
        }else if("学生".equals(role)){
            account = studentInfoMapper.selectByPrimaryKey(key);
        }else if("老师".equals(role)){
            account = teacherInfoMapper.selectByPrimaryKey(key);
        }
        if(account==null){
            return false;
        }
        Integer accountId = accountInfoMapper.selectOnly(accountInfo);
        if(accountId==null||accountId.equals("")||accountId==0){
            accountInfoMapper.insertSelective(accountInfo);
            return true;
        }
        return false;
    }
}
