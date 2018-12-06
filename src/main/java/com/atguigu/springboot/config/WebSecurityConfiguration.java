package com.atguigu.springboot.config;
import com.atguigu.springboot.MyFilterInvocationSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yanglf
 * @sine 2018.12.03
 * @descriptipon
 * @see
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

   /* @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;

    @Autowired
    private MyFilterInvocationSecurity myFilterInvocationSecurity;*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().anonymous();

        //  CSRF    token 认证方式
       /* http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository())
        .requireCsrfProtectionMatcher(httpServletRequest ->
                httpServletRequest.getMethod().equals("POST"));

        //  CSP  只允许加载  https://cdnjs.cloudflare.com 域名下的js文件  其他的会加载失败
        http.headers().contentSecurityPolicy("script-src https://cdnjs.cloudflare.com");

        // X-Frame-Options header  iframe 相同域名可以访问
        http.headers().frameOptions().sameOrigin();
        // 实现绝对访问  添加访问白名单
        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new AllowFromStrategy() {
            @Override
            public String getAllowFromValue(HttpServletRequest httpServletRequest) {
                return "baidu.com";
            }
        }));

        // XSS  header   防止js注入
        http.headers().xssProtection().block(false);

        // 授权
        http.authorizeRequests().anyRequest().fullyAuthenticated()
               *//* .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(myFilterInvocationSecurity);
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        return null;
                    }
                })*//*
                .and()
                .formLogin()
                .usernameParameter("name")
                .passwordParameter("pwd")
                .loginPage("/login")    //  登录页面URL
                .failureForwardUrl("/error")   // 登录失败页面URL
                .loginProcessingUrl("/loginAction")  // 登录处理的URL
                .permitAll()
                 .and()
                  .logout().permitAll();*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      /*  auth.inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())   // Spring Boot 2.0 之后必须要配置密码加解密方式
                .withUser("yanglf").password("yanglf123").roles("ADMIN")
        .and()
        .withUser("liudehua").password("123456").roles("USER");*/

        //加载注入的用户信息
       // auth.userDetailsService(new MyUserDetailsServiceImpl());


    }
}
