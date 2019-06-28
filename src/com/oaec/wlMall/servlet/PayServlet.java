package com.oaec.wlMall.servlet;

import com.oaec.wlMall.service.OrderService;
import com.oaec.wlMall.service.UserService;
import com.oaec.wlMall.service.impl.OrderServiceImpl;
import com.oaec.wlMall.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> user = (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        System.out.println("user_id = " + user_id);
        int add_id = Integer.parseInt(req.getParameter("add_id"));
        System.out.println("add_id = " + add_id);
        String[] comm_ids = req.getParameterValues("comm_id");
        System.out.println("comm_ids = " + Arrays.toString(comm_ids));
        boolean submit = orderService.submit(user_id, add_id, comm_ids);
        System.out.println("submit = " + submit);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+submit+"}");
        writer.close();

    }
}
