package com.oaec.wlMall.servlet;

import com.oaec.wlMall.service.ComService;
import com.oaec.wlMall.service.OrderService;
import com.oaec.wlMall.service.impl.CommServiceImpl;
import com.oaec.wlMall.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/single")
public class ProductServlet extends HttpServlet {
    private ComService comService = new CommServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int comm_id = Integer.parseInt(req.getParameter("comm_id"));
        Map<String, Object> commodity = comService.getCommodity(comm_id);

        System.out.println(commodity);
        req.setAttribute("commodity",commodity);
        req.getRequestDispatcher("/WEB-INF/views/single.jsp").forward(req,resp);
    }
}
