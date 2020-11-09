package com.bksoftwarevn.itstudent.controller.pack_request_attr_session_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestCookie", value="/test-cookie")
public class TestCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //khi gọi bằng trình duyệt thì sẽ xử lý trong hàm doGet
        //Một do thường có 2 tham số truyền vào
        //HttpServletRequest chứa các thông người dùng truyền lên server
        //HttpServletResponse chứa kết quả trả về sau khi server xử lý

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        //lấy thông tin client request attribute
        //String nameClient = (String) request.getAttribute("name-client");

        //lây thông tin client trong session thì phải làm việc với đối tượng HttpSession trong request
        //HttpSession session = request.getSession();
        //String nameClient = (String) session.getAttribute("name-client");

        //lấy thông tin client trong cookie được client gửi lên là dạng một mảng Cookie chứa các thông tin
        //được lưu trữ ở client
        Cookie cookies[] = request.getCookies();
        //trong mảng này lưu trữ các đối tượng cookie có cặp key value đã được set từ trường
        String nameClient = null;
        if(cookies != null) {
            for (Cookie c: cookies) {
                if(c != null && c.getName().equals("name-client")) {
                    nameClient = c.getValue();
                    break;
                }
            }
        }
        //sửa thông tin cookie
        Cookie cookie = new Cookie("name-client", "ITStudent");
        response.addCookie(cookie);
        response.getWriter().println("<h1>Trang Chu: "+nameClient+"</h1>");
    }
}
