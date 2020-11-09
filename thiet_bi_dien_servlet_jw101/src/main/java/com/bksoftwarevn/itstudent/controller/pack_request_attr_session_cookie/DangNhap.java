package com.bksoftwarevn.itstudent.controller.pack_request_attr_session_cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * - Về đọc slide về 2 cơ chế stateless và statefull, phân biệt stateless và statefull
 * HTTP là một giao thức stateless.
 * Cớ chế stateless được hiểu là không lưu trữ trang thái làm việc với request của client trước đó
 * Nói về trường hợp đăng nhập thì stateless hoạt động:
 *  - Để đưng nhập thì client cần request đến trang đăng nhập sau khi đăng nhập thành công thì
 *  tiến hành chuyển đến trang chủ. Và tại trang chủ thì không có một thông tin nào nói về
 *  client đã đăng nhập hay chưa để xử lý tiếp.
 *  => Cần cải tiến chức năng đăng nhập làm sao cho giống thằng facebook nhất thì cần thêm một số kỹ
 *  thuật để phân biệt được user đã đăng nhập hay chưa
 *      - Để biết user đã đăng nhập hay chưa thì phải lưu trữ được thông tin client đã đăng nhập
 *      - Cơ chế sau để xử lý lưu trữ  thông tin cửa client:
 *             - request attribute
 *             - session
 *             - cookie
 * => Mỗi kỹ thuật sẽ có một phạm vi lưu thông tin khác nhau, tùy từng trường hợp mình hợp nên sử
 * dụng phạm vi nào.
 */
@WebServlet(name = "DangNhap", value = "/dang-nhap")
public class DangNhap extends HttpServlet {
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
            //nếu đúng thực hiện chuyển hướng sang trang chủ

            /**
             * Thực hiện lưu trữ thông tin bằng request attribute
             * Phân tích sendRedirect và RequestDispatcher dưới góc nhìn request:
             *  + sendRedirect: đầu tiên gửi 1 request đến trang đăng nhập để thực hiện đăng nhập
             *  nếu đăng nhập thành công => tạo ra 1 request để yêu cầu đến trang chủ và hiện thị
             *  nội dung trang chủ (2 request)
             *  + forward: gửi 1 request đến trang đăng nhập nếu thực thực hiện đăng nhập thành công
             *  thì chuyển hướng đến trang chủ (nhưng chuyển hướng được thực hiện trong server) và
             *  lúc này sẽ trả về kết quả hiện thị trang chủ (1 request)
             *  => Phạm vi hoạt động của request attribute chỉ tồn tại trong 1 request
             *  => Làm sao để trong request thứ 2..n vẫn tồn tại thông tin của user đã đăng nhập
             */
//            response.sendRedirect("trang-chu");
            RequestDispatcher rd = request.getRequestDispatcher("trang-chu");
            //Thực hiện lưu trữ thông tin client đã đăng nhập và trong đối tượng request và chuyển
            //đối tượng đấy trên trang chủ
            request.setAttribute("name-client","ITStudent");
            rd.forward(request, response);
        } else {
            response.getWriter().println("<h1>Tài khoản hoặc mật khẩu không đúng!</h1>");
        }
    }
}
