package com.oaec.wlMall.servlet;

import com.oaec.wlMall.service.*;
import com.oaec.wlMall.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
    private AddressService addressService= new AddressServiceImpl();
    private AchiService achiService = new AchiServiceImpl();
    private OrderService orderService =new OrderServiceImpl();
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        List<Map<String, Object>> maps = addressService.queryByUser_id(user_id);
        List<Map<String, Object>> orders = orderService.getOrders(user_id);
        Map<String, Object> achi_name = achiService.queryByUser_id(user_id);
        Map<String, Object> map = userService.queryAchieve(user_id);

        req.setAttribute("achi",map);
        System.out.println(orders);
        req.setAttribute("orders",orders);
        req.setAttribute("achi_name",achi_name);
        req.setAttribute("address",maps);
        req.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(req,resp);
    }
}
