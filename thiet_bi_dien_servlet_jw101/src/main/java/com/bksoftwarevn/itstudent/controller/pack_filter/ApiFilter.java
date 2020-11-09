package com.bksoftwarevn.itstudent.controller.pack_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


//sau này các url trả về api của mình nó sẽ tuân thử dạng như sau:
// api/v1/product, api/v1.1/category
@WebFilter(filterName = "ApiFilter", urlPatterns = {"/api/*"})
public class ApiFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        System.out.println("Api Filter" + servletRequest.getRequestURI());
        resp.setContentType("application/json;charset=UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
