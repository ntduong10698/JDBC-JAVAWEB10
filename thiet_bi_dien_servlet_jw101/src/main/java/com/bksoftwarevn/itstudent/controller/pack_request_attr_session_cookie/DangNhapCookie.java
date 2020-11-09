package com.bksoftwarevn.itstudent.controller.pack_request_attr_session_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DangNhapCookie", value = "/dang-nhap-cookie")
public class DangNhapCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cấu hình request và response làm việc với UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*"); //chấp mọi kết nối

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //khi mà không truyền lên 2 thông tin usernamee và password thì giá trị của 2 string
        //sẽ bị null
        if(username != null && password !=  null
                && username.equals("root") && password.equals("root")) {
            /**
             * - Lữu trữ thông tin trong cookie phạm vi lớn hơn phạm vi của session
             * - 2 cách lưu trữ trên là sử dụng cơ chế lưu trữ thông tin trên server
             * còn cookie sửa dụng cơ chế thông tin được lưu trên client
             * - Cookie là các tập tin văn bản được lưu trữ trên trình duyệt người dùng.
             * - Để lưu trữ được thông tin (thì cơ chế phải khác hăn 2 kỹ thuật trên) phải tạo
             * ra một đối tượng Cookie chứa thông tin người dùng và gửi thông tin đó cho client trữ trữ
             */
            Cookie cookie = new Cookie("name-client", "ITStudent-Cookie");
            cookie.setMaxAge(24*3600);//thời gian sống của cookie
            //cookie.setPath("/thiet_bi_dien_servlet_jw101_war/trang-chu");
            response.addCookie(cookie);//gửi thông tin cookie cho client lưu trữ
            response.sendRedirect("trang-chu");
            //thêm một số kĩ thuật quản lý cookie//
            // - Sửa thông tin cookie
            // - Giới hạn phạm vi hoạt động của cookie trong url
        } else {
            response.getWriter().println("<h1>Tài khoản hoặc mật khẩu không đúng!</h1>");
        }
    }
}
