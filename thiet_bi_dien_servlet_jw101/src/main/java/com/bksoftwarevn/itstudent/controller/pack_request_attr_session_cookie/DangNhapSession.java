package com.bksoftwarevn.itstudent.controller.pack_request_attr_session_cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DangNhapSession", value="/dang-nhap-session")
public class DangNhapSession extends HttpServlet {
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
             * - Lưu trữ thông tin bằng session phạm vi lớn request attribute
             * - Session là phiên làm việc giữa client và server (phiên làm việc được tính từ
             * lúc đăng nhập đến lúc tắt trình duyệt)
             * - Phạm vi trữ thông tin bằng session là phạm vi trong phiên làm việc
             * - Để làm việc với session thì cần phải sử dụng đối tượng HttpSession trong request
             * bằng hàm getSession();
             * => Đặt ra vấn đề làm sao có thể lưu trữ thông tin của client đã đăng nhập kể cả khi
             * tắt trình duyệt hoặc thậm chí là tắt máy nhưng thông tin vẫn còn được lưu
             */
            HttpSession session = request.getSession();
            session.setAttribute("name-client", "ITStudent-Session");
            response.sendRedirect("trang-chu");
        } else {
            response.getWriter().println("<h1>Tài khoản hoặc mật khẩu không đúng!</h1>");
        }
    }
}
