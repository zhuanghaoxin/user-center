package com.zhx.usercenter.service;
import java.util.Date;

import com.zhx.usercenter.model.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("HaoXin");
        user.setUserAccount("123");
        user.setAvatarUrl("http:xxx");
        user.setGender(0);
        user.setUserPassword("xx");
        user.setPhone("123");
        user.setEmail("zhx@qq.com");
        boolean result = userService.save(user);
        log.info("result :{}",result);
        Assertions.assertTrue(result);

    }
}