package com.oaec.wlMall.servlet;

import com.oaec.wlMall.entity.Commodity;
import com.oaec.wlMall.service.ComService;
import com.oaec.wlMall.service.NavService;
import com.oaec.wlMall.service.impl.CommServiceImpl;
import com.oaec.wlMall.service.impl.NavServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private ComService comService= new CommServiceImpl();
    private NavService navService = new NavServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String tid = req.getParameter("tid");
        String bid =req.getParameter("bid");
        String page = req.getParameter("page");
        System.out.println("name = " + name);
        List<Map<String,Object>> query = comService.query( name,tid,bid,Integer.parseInt(page));
        System.out.println("query = " + query);
        req.setAttribute("query",query);
        List<Map<String,Object>> nav = navService.getNav();
        req.setAttribute("nav",nav);
        req.getRequestDispatcher("/WEB-INF/views/product.jsp").forward(req,resp);
    }
}
