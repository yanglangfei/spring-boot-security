package com.atguigu.springboot.service;

import com.atguigu.springboot.model.UserEntity;

/**
 * @author yanglf
 * @sine 2018.12.04
 * @descriptipon
 * @see
 */
public interface UserService {

    UserEntity loadByUser(String userName);


}
