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

@WebServlet("/loginTwo")
public class Login2Servlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password5");
        String number4 = req.getParameter("number4");

        String uri = req.getParameter("uri");
        Map<String, Object> map1 = userService.login2(number4, password);

        Map<Object, Object> json = new HashMap<>();
        if (map1.containsKey("user")){
            req.getSession().setAttribute("user",map1.get("user"));
            json.put("result",true);
            if (uri!=null){
                json.put("uri",uri);
            }
        }else {
            Object error = map1.get("error");
            json.put("result",false);
            json.put("error",error);
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer =resp.getWriter();
        writer.println(JSON.toJSONString(json));
        writer.close();

    }
}
