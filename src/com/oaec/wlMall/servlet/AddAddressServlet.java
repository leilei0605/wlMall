package com.oaec.wlMall.servlet;

import com.oaec.wlMall.service.AddressService;
import com.oaec.wlMall.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/person/addAddress")
public class AddAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("re_name");
       Integer number = Integer.parseInt(req.getParameter("re_number"));
        String address = req.getParameter("address");
        Map<String, Object> user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        int isDefault = Integer.parseInt(req.getParameter("isDefault"));
        boolean b = addressService.addAddress(name, number, address, user_id, isDefault);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+b+"}");
        writer.close();


    }
}
