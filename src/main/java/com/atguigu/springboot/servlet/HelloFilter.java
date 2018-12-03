package com.atguigu.springboot.servlet;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * XXX company
 * Copyright (c) 2018, xxx All Rights Reserved.
 *
 * @author yanglf
 * @date 2018/12/2/002
 * @descriptipon
 */
@WebFilter(servletNames = "helloServlet")
public class HelloFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ServletContext servletContext = httpServletRequest.getServletContext();
        servletContext.log("request url:"+httpServletRequest.getRequestURI());
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
