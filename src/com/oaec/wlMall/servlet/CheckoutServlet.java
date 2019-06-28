package com.oaec.wlMall.servlet;

import com.oaec.wlMall.service.AddressService;
import com.oaec.wlMall.service.CartService;
import com.oaec.wlMall.service.impl.AddressServiceImpl;
import com.oaec.wlMall.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    private AddressService addressService =new AddressServiceImpl();
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        String[] comm_ids = req.getParameterValues("comm_id");
        //查收货地址
        List<Map<String, Object>> addressList = addressService.queryByUser_id(user_id);
        //查询要结算的商品
        List<Map<String, Object>> commodityList = cartService.getCommodities4Checkout(user_id, comm_ids);
       //查询统计
        Map<String, Object> total = cartService.getTotal(user_id, comm_ids);
        req.setAttribute("addressList",addressList);
        req.setAttribute("commodityList",commodityList);
        req.setAttribute("total",total);
        System.out.println(total);
        req.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(req,resp);
    }
}
