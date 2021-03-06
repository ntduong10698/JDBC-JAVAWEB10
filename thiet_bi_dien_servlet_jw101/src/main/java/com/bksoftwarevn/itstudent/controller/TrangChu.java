package com.bksoftwarevn.itstudent.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet là một class bình thương và exteds HttpServlet
 * Một Servlet nó sẽ có hàm init() chỉ chạy 1 lần khi nó được khởi tạo, destroy() chỉ chạy một
 * lần khi servlet bị hủy
 * Còn doGet, doPost là các hàm được chạy đi chạy lại nhiều lần mỗi lần người dùng request đến server
 * Do HTTP có 4 phương thức GET, PUT, POST, DELETE => tương ứng với 4 phương thức này sẽ có 4 hàm do tương
 * ứng
 * Khi người dùng request đến server bằng phương thức http thì phải kèm theo 1 trong 4 phương thức
 * 4 phương thức đều có ý nghĩa riếng:
 *  Get: lấy dữ liệu
 *  Put: sửa dữ liệu
 *  Post: thêm dữ liệu
 *  Delete: xóa dữ liệu
 * => tương ứng với các phương thức trên thì nó cũng là các hành động mình làm với đối tượng
 * tức là thêm sửa xóa dữ liệu.
 * => Khi request bằng trình duyệt thì phương thức sẽ mặc định là Get và để gọi đến các phương thức
 * khác thì phải dùng các công cụ khác (postman)
 */ 
@WebServlet(name = "TrangChu", value = "/trang-chu")
public class TrangChu extends HttpServlet {
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
        response.getWriter().println("<h1>Trang Chu: "+nameClient+"</h1>");
    }
}
