package com.atguigu.springboot.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author yanglf
 * @sine 2018.12.04
 * @descriptipon
 * @see
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        // 权限认证处理
        // collection 就是之前 MyFilterInvocationSecurity 类传过来的权限集合
        //  authentication   用户的认证信息
        Iterator<ConfigAttribute> iterator = collection.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();
            String role = configAttribute.getAttribute();
            // URL 需要登录  但是 用户权限没有权限
            if ("ROLE_LOGIN".equals(role)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("需要登录");
                }
                return;
            }
            //  获取当前用户拥有的权限
            Collection<? extends GrantedAuthority> currentUserAuthority=authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : currentUserAuthority) {
                if(grantedAuthority.getAuthority().equals(role)){
                    return;
                }
            }
            throw new AccessDeniedException("权限不足");

        }

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
