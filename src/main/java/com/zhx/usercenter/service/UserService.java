package com.zhx.usercenter.service;

import com.zhx.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 30703
* @description 针对表【user】的数据库操作Service
* @createDate 2023-02-10 00:05:26
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册服务
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 检验码
     * @return 用户Id
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);
}
