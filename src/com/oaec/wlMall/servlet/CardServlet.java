package com.oaec.wlMall.servlet;

import com.oaec.wlMall.service.CartService;
import com.oaec.wlMall.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/cart")
public class CardServlet extends HttpServlet {
  private CartService cartService=  new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前用户的编号
        Map<String, Object>user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        List<Map<String, Object>> cartCommodity = cartService.getCartCommodity(user_id);
        System.out.println("comm:"+cartCommodity);
        req.setAttribute("commodity",cartCommodity);

        req.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(req,resp);
    }
}
