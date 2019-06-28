package com.oaec.wlMall.servlet;

import com.oaec.wlMall.service.CartService;
import com.oaec.wlMall.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/updateQuantity")
public class UpdateQuantityServlet extends HttpServlet {
    private CartService cartService =new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户编号 产品编号 和动作
        Map<String, Object> user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        int comm_id = Integer.parseInt(req.getParameter("comm_id"));
        String action =req.getParameter("action");
        System.out.println(action+"+"+comm_id+"+"+user_id);
        boolean b = cartService.updateQuantity(action, user_id, comm_id);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+b+"}");
        writer.close();
    }
}
