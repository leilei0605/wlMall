package com.oaec.wlMall.servlet;

import com.alibaba.fastjson.JSON;
import com.oaec.wlMall.service.CartService;
import com.oaec.wlMall.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/queryTotal")
public class QueryTotalServlet extends HttpServlet {
    private CartService cartService= new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        String[] comm_ids = req.getParameterValues("comm_id");
        Map<String, Object> total = cartService.getTotal(user_id, comm_ids);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(JSON.toJSONString(total));
        writer.close();
    }
}
