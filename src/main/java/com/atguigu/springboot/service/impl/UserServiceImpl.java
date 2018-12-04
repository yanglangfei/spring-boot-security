package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.model.UserEntity;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author yanglf
 * @sine 2018.12.04
 * @descriptipon
 * @see
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity loadByUser(String userName) {
        UserEntity userEntity=new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setUserName("zhangsan");
        userEntity.setPasswrod(passwordEncoder.encode("zhangsan123"));
        return userEntity;
    }
}
