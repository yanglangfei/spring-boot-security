package com.atguigu.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * XXX company
 * Copyright (c) 2018, xxx All Rights Reserved.
 *
 * @author yanglf
 * @date 2018/12/1/001
 * @descriptipon
 */
@Configuration
@ConfigurationProperties(prefix = "per")
public class Person {
    private String name;
    private String pwd;
    private String address;

    public  void  show(){
        System.out.println("name:"+name+";pwd:"+pwd+";address:"+address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
