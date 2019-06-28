package com.oaec.wlMall.filter;

import com.alibaba.fastjson.JSON;
import com.oaec.wlMall.util.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebFilter({"/check","/cart","/checkout","/person","/updateAddress"})
public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String queryString = request.getQueryString();
        if (session.getAttribute("user") == null) {
            String requestURI = request.getRequestURI();
            if (requestURI.endsWith("delete") || requestURI.endsWith("save")) {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter writer = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("isLogin", false);
                writer.println(JSON.toJSONString(map));
                writer.close();
            } else {
                response.sendRedirect(request.getContextPath() + "/login?uri=" + requestURI + "?" + queryString);
            }
        }else {
            filterChain.doFilter(request, response);

        }

    }}
