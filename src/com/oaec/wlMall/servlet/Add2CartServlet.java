package com.oaec.wlMall.servlet;

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

@WebServlet("/add2cart")
public class Add2CartServlet extends HttpServlet {
    private CartService cartService =new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object>user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        System.out.println(user_id);
        //获取请求参数 comm_id quantity
        int comm_id = Integer.parseInt(req.getParameter("comm_id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        boolean b = cartService.addCart( quantity,user_id, comm_id);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+b+"}");
        writer.close();
    }
}
