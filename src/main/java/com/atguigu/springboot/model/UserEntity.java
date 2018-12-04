package com.atguigu.springboot.model;

/**
 * @author yanglf
 * @sine 2018.12.04
 * @descriptipon
 * @see
 */
public class UserEntity {
    private String id;
    private String userName;
    private String passwrod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }
}
