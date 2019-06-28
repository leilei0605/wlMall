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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

   private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String uri = req.getParameter("uri");
        Map<String, Object> map = userService.login(username,username, password);
        System.out.println(map);
        Map<Object, Object> json = new HashMap<>();
        if (map.containsKey("user")){
            req.getSession().setAttribute("user",map.get("user"));
            json.put("result",true);
            if (uri!=null){
                json.put("uri",uri);
            }
        }else {
            Object error = map.get("error");
            json.put("result",false);
            json.put("error",error);
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer =resp.getWriter();
        writer.println(JSON.toJSONString(json));
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
    }
}
