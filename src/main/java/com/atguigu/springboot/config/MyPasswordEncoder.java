package com.atguigu.springboot.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yanglf
 * @sine 2018.12.03
 * @descriptipon  spring boot 2.0 之后必须要创建这个类
 * @see
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
