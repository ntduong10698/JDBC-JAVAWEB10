package com.bksoftwarevn.itstudent.controller.pack_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * + Fitler: là tiền xử lý request của client trước khi đến servlet và hậu xử lý response sau khi gửi phản
 * hồi đến client
 *      => chạy kiểm soát request trước khi gửi đến servlet
 *      => chảy kiểm soát response trước khi gửi về cho client
 * + Mô hình filter
 * + Có 3 hàm:
 *      + init: sẽ chạy khi filter được sinh ra
 *      + destroy: sẽ hạy khi filter bị hủy
 *      + doFilter: (lặp đi lặp lại)khi nào client request đến thì sẽ được chạy
 * - Filter thường được sử dụng khi nào
 *      + Bảo mật: BTVN tạo ra một trang servlet product hiện thị <h1>Product</h1> nhưng trang
 *      trang này thuộc urll /view/* tương ứng với url /view/* chỉ cho phe người
 *      dùng đã đăng nhập, nếu chuaw đăng nhập sẽ in ra thống báo
 *      <h1>Không có quyền</h1> làm sao trả về được HTTP Status Codes tượng với với không có quyền.
 *      + Cấu hình chung
 *      + ...
 * BT1:
 *  *      + Bảo mật: BTVN tạo ra một trang servlet product hiện thị <h1>Product</h1> nhưng trang
 *  *      trang này thuộc urll /view/* tương ứng với url /view/* chỉ cho phe người
 *  *      dùng đã đăng nhập, nếu chuaw đăng nhập sẽ in ra thống báo
 *  *      <h1>Không có quyền</h1> làm sao trả về được HTTP Status Codes tượng với với không có quyền.
 * BT2: các url có dạng api/* đều yêu cầu thao tác với database,
 * trước khi thao tác database thì phải tạo connection
 * => Api Filter thì thực hiện lấy nối đến database (
 * nếu đã kết nối thì cho quan luôn, nếu chưa kết nối thì phải thực kết nối)
 */
@WebFilter(filterName = "LearnFilter")
public class LearnFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
