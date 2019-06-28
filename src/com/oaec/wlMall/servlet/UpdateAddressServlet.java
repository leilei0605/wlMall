package com.oaec.wlMall.servlet;

import com.oaec.wlMall.dao.AddDao;
import com.oaec.wlMall.service.AddressService;
import com.oaec.wlMall.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateAddress")
public class UpdateAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipient = req.getParameter("re_name");
        int re_number = Integer.parseInt(req.getParameter("re_number"));
        String address = req.getParameter("address");
        int add_id = Integer.parseInt(req.getParameter("add_id"));
        boolean b = addressService.updateAddress(recipient, re_number, address, add_id);
        System.out.println(b);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+b+"}");
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String add_id = req.getParameter("add_id");
        req.setAttribute("add_id",add_id);
        req.getRequestDispatcher("/WEB-INF/views/updateAddress.jsp").forward(req,resp);
    }
}
