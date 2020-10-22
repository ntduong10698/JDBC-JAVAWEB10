package com.bksoftwarevn.itstudent.controller.pack_request_dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//RequestDispatcher là một interface cung cấp các cơ chế điều kiền request

/**
 * Cung cấp 2 cơ chế điều kiển:
 *      + Gửi request của client sang một tài nguyên khác trên server: forward
 *      + Bao gồm một tài nguyên khác trên server: include
 * + Forward: sẽ điều hướng sang tài nguyền khác và chỉ hiện thị nội dụng của trang tài nguyên đó
 * + Include: sẽ bao gồm cả nội dụng trả về của trang hiện tại và trang được bao gồm
 */

/**
 * Tạo ra 1 serlvet để phục vụ chức năng đăng nhập
 * - Servlet DangNhap: người dùng truyền lên queryString chứa 2 thông tin username và password
 * - kiểu tra nếu userrname = "root" và password="root" thì thực hiện chuyển hướng đến trang chủ
 * - nếu khác thì in ra Tài khoản hoặc mật khẩu không đúng.
 */
@WebServlet(name = "LearnRequestDispatcher", value = "/learn-request-dispatcher")
public class LearnRequestDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Learn Request Dispatcher</h1>");
        String forward = request.getParameter("forward");
        //để sử dụng được request dispatcher thì sử dụng pt getRequestDispathcer trong đối tượng
        //request
        RequestDispatcher rd = request.getRequestDispatcher("test-request-dispatcher");
        if(forward.equals("true")) {
            //thực hiện forward
            rd.forward(request, response);
        } else {
            //thực hiện include
            rd.include(request, response);
        }
    }
}
