package com.bksoftwarevn.itstudent.controller.pack_request_dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestRequestDispatcher", value = "/test-request-dispatcher")
public class TestRequestDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Sử dụng query String trong url để lấy được thông người dùng khi nào muốn forward hoặc include
        //Cấu tạo queryString ?key=value&key1=value1 (được định nghĩa sau dấu ? là đi theo cặp
        // key và value giữa các cắp có &)
        //để lấy lấy giá trị dùng request và truyền đúng key
        String forward = request.getParameter("forward");
        response.getWriter().println("<h1>Forward: "+forward+"</h1>");
    }
}
