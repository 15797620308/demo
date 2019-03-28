package com.example.service;

import com.example.mapper.AccountInfoMapper;
import com.example.model.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service(value = "loginService")
public class LoginService {
    @Autowired
    private AccountInfoMapper accountInfoMapper;

    public boolean findManager(AccountInfo accountInfo, HttpSession session){
        String account = accountInfo.getUseraccount();
        String pwd = accountInfo.getUserpwd();
        AccountInfo useraccount = accountInfoMapper.selectByAccount(account);
        boolean result = true;
        if(useraccount==null){
            result = false;
        }else{
            if(useraccount.getUserpwd().equals(pwd)){
                session.setAttribute("user",useraccount);
            }else{
                result = false;
            }

        }
        return result;
    }

    public void exit(HttpSession session){
        session.removeAttribute("user");
    }

    public int changePwd(AccountInfo accountInfo){
        int result = accountInfoMapper.updateByPrimaryKeySelective(accountInfo);
        return result;
    }

}
