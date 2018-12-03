package com.atguigu.springboot.boot;

import javax.servlet.ServletException;
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
public class HelloServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("Hello,SpringBoot !!!");
        writer.flush();
        writer.close();
    }
}
