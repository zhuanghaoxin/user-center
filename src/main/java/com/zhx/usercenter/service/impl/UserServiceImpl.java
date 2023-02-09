package com.zhx.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhx.usercenter.model.domain.User;
import com.zhx.usercenter.service.UserService;
import com.zhx.usercenter.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author 30703
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-02-10 00:05:26
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        if(StringUtils.isAnyBlank(userAccount,userPassword,checkPassword)){
            return -1;
        }
        if (userAccount.length() < 4){
            return -1;
        }
        if (userPassword.length() < 8 || checkPassword.length() <8){
            return -1;
        }
        //账户不能包括特殊字符，使用正则表达式进行校验
        String validPattern = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if(!matcher.find()){
            return -1;
        }
        //密码和校验码必须相同
        if(!userPassword.equals(checkPassword)){
            return -1;
        }
        //用户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        if(this.count(queryWrapper) > 0){
            return -1;
        }
        return 0;
    }
}




