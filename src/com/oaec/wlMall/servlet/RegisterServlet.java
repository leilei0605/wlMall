package com.oaec.wlMall.servlet;

import com.alibaba.fastjson.JSON;

import com.oaec.wlMall.service.UserService;

import com.oaec.wlMall.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
  private UserService userService =new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username7");
        String password = req.getParameter("password1");
        String number = req.getParameter("number");
        String payword = req.getParameter("payword1");
        Map<String, Object> register = userService.register(username, password, payword,number);
        Map<Object, Object> json = new HashMap<>();
        if (register.containsKey("success")){
            json.put("result",true);
        }else {
            Object error = register.get("error");
            json.put("result",false);
            json.put("error",error);
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer =resp.getWriter();
        writer.println(JSON.toJSONString(json));
        writer.close();


    }
}
