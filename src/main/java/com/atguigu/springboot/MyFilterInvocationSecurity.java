package com.atguigu.springboot;


import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.Collection;
import java.util.List;

/**
 * @author yanglf
 * @sine 2018.12.04
 * @descriptipon
 * @see
 */
public class MyFilterInvocationSecurity implements FilterInvocationSecurityMetadataSource {

    private List<String> roles;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) o;
        String requestUrl = filterInvocation.getRequestUrl();
        System.out.println("当前请求URL："+requestUrl);
        if(requestUrl.equals("/login")){
            return null;
        }
        //   根据 URL  从数据库查询对应的角色
        if (roles != null) {
            String [] roleArry=new String[roles.size()];
            for (int i = 0; i < roles.size(); i++) {
                roleArry[i] = roles.get(i);
            }
            // 将权限认证逻辑交给 MyAccessDecisionManager 处理
          return   SecurityConfig.createList(roleArry);
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
