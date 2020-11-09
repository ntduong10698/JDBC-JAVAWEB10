package com.bksoftwarevn.itstudent.controller.pack_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "AllFilter", urlPatterns = {"/*"})
public class AllFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //in ra thông tin request đến => HttpServletRequest
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        System.out.println("All Filter" + servletRequest.getRequestURI());
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //text/html chỉ sử dụng cho các servlet trả về giao diện
        //application/json trả về cho mình file dưới dạng json => api
        //Ở đối tượng ServletResponse sẽ cung cấp hàm .setHeader
        //Phải sử dụng đối tượng HttpServletReponse
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Access-Control-Allow-Origin", "*");
        chain.doFilter(req, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
