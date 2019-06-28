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

@WebServlet("/addBalance")
public class AddBalanceServlet extends HttpServlet {
    private UserService userService =new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double money = Double.parseDouble(req.getParameter("money"));
        Map<String, Object> user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        Double balance = userService.addBalance(money, user_id);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("balance",balance);
        writer.println(JSON.toJSONString(objectObjectHashMap));
        writer.close();
    }
}
