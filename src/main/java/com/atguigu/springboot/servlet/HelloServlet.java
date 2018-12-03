package com.atguigu.springboot.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * XXX company
 * Copyright (c) 2018, xxx All Rights Reserved.
 *
 * @author yanglf
 * @date 2018/12/2/002
 * @descriptipon
 */
@WebServlet(
        name = "helloServlet",
        urlPatterns = {"/hello"},
        initParams = {
        @WebInitParam(name = "userName",value = "admin")
        })
public class HelloServlet extends HttpServlet {

    private String userName;

    @Override
    public void init(ServletConfig config) throws ServletException {
         userName = config.getInitParameter("userName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("Hello,Servlet!!    "+userName);
        writer.flush();
        writer.close();
    }
}
