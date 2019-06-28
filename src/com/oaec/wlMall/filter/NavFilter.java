package com.oaec.wlMall.filter;

import com.oaec.wlMall.service.NavService;
import com.oaec.wlMall.service.impl.NavServiceImpl;
import com.oaec.wlMall.util.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebFilter({"/index","/list","/product","/single","/cart","/person","/checkout","/updateAddress"})
public class NavFilter extends HttpFilter {
   private NavService navService= new NavServiceImpl();
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        List<Map<String,Object>> nav = navService.getNav();
        request.setAttribute("nav",nav);
        filterChain.doFilter(request,response);
    }
}
