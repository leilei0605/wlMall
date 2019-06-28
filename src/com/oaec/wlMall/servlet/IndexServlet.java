package com.oaec.wlMall.servlet;

import com.oaec.wlMall.dao.ComDao;
import com.oaec.wlMall.dao.impl.ComDaoImpl;
import com.oaec.wlMall.entity.Commodity;
import com.oaec.wlMall.entity.Type;
import com.oaec.wlMall.service.NavService;
import com.oaec.wlMall.service.impl.NavServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
//    private NavService navService = new NavServiceImpl();
    private ComDao comDao=new ComDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询出导航需要的分类
//        List<Map<String,Object>> nav = navService.getNav();
//        req.setAttribute("nav",nav);


        //转发到index.jsp
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }
}
