package com.bksoftwarevn.itstudent.controller.pack_url_pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Khi 2 url đều trả về 1 kết quả giống nhau
//=> 1 severlet có thể xử lý cho nhiều url
//Quy tắc đặt lên url: tất cả đều viết thường phần cách bằng -
@WebServlet(name = "LearnUrlPattern", urlPatterns = {"/learn-url-pattern/*", "/hoc-url-pattern"})
public class LearnUrlPattern extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Learn Url Pattern</h1>");
        //in ra url để biết đang xử lý chính xác cho trang
        //để lấy ra url thì sẽ sử dụng đối tượng request
        response.getWriter().println("<h2>"+request.getRequestURL()+"</h2>");
        //lấy ra URI
        response.getWriter().println("<h2>"+request.getRequestURI()+"</h2>");
        //lấy servlet path
        response.getWriter().println("<h2>"+request.getServletPath()+"</h2>");
        //lấy path info
        response.getWriter().println("<h2>"+request.getPathInfo()+"</h2>");
    }
}
