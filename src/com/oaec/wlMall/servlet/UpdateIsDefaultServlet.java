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

@WebServlet("/person/updateIsDefault")
public class UpdateIsDefaultServlet extends HttpServlet {
    private AddressService addressService= new AddressServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> user= (Map<String, Object>) req.getSession().getAttribute("user");
        int user_id = Integer.parseInt(user.get("USER_ID").toString());
        int add_id = Integer.parseInt(req.getParameter("add_id"));
        boolean b = addressService.updateIsDefault(user_id, add_id);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+b+"}");
        writer.close();
    }
}
