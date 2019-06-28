package com.oaec.wlMall.servlet;

import com.oaec.wlMall.service.OrderService;
import com.oaec.wlMall.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/returnGoods")
public class ReturnOfGoods extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int comm_id = Integer.parseInt(req.getParameter("comm_id"));
        double price = Double.parseDouble(req.getParameter("price"));
        double money = price*quantity;
        int dbid= Integer.parseInt(req.getParameter("dbid"));
        boolean b = orderService.returnOfGoods(quantity, comm_id, money, user_id,dbid);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+b+"}");
        writer.close();
    }
}
