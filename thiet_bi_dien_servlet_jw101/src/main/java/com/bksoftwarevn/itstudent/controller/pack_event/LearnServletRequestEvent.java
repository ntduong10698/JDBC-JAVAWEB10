package com.bksoftwarevn.itstudent.controller.pack_event;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

/**
 * Một Listener à một class bình thường nhưng sẽ implements một interface
 * Listener tương ứng của event
 */

/**
 * => là gì, làm được gì, chạy khi nào
 * ServletRequestEvent là một sự kiện về các request trong servlet (request này là gì)
 * Cung cấp 2 sự kiện:
 *       + Sư kiện request được tạo ra
 *       + Sự kiện request bị hủy
 * Tương ứng với 2 sjw kiện trên thì sẽ có 2 phương thức tương ứng phải định nghĩa:
 * => Khi sự kiện xảy ra thì các câu lệnh trong hàm sẽ được thực hiện:
 *       - in ra màn hình sự kiện nào xảy ra và thời điểm xảy ra => khi nào sự kiện chạy
 *      + Đầu vào của 2 hàm à một đối tượng ServleRequestEvent
 *      + ĐỐi tượng tượng ServetRequestEvent cho phép mình lấy ra đối tượng ServetRequest bằng hàm
 *      getServletRequest:
 *          + Bình thường khi làm việc với servet thì các sẽ làm việc với đối tượng HttpServletRequest
 *          thì đối tượng HttpServletRequest là thằng con kế thừa thằng ServetRequest.
 *              + Khi client giao tiếp với servlet thì thông qua đối tượng request, nhưng đối tượng request
 *              có thể chấp nhận nhiều giao thước: http (HttpServeletRequest), ftp (giao thức truyền tập tìn)...
 * => khi client gửi một request lên servler thì đối tượng ServletRequest sẽ được tạo ra chức các thông
 * tin người dùng truyền lên, và sau khi lý trả về kết quả bằng một response thì tại thời điểm này
 * đối tượng ServletRequest sẽ được hủy để giải phóng tài nguyên
 *
 */
@WebListener
public class LearnServletRequestEvent implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        // lấy ra đối tượng servletRequest bằng hàm getServletRequest
        ServletRequest  servletRequest = servletRequestEvent.getServletRequest();
        //lấy ra giao thức sử dụng bằng hàm getProtocol trong đối tượng ServletRequest
        String protocol = servletRequest.getProtocol();
        //System.out.println("Destroy Request: "+ protocol+ " - " + new Date().getTime());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        // lấy ra đối tượng servletRequest bằng hàm getServletRequest
        ServletRequest  servletRequest = servletRequestEvent.getServletRequest();
        //lấy ra giao thức sử dụng bằng hàm getProtocol trong đối tượng ServletRequest
        String protocol = servletRequest.getProtocol();
        //System.out.println("Init Request: "+ protocol+ " - " + new Date().getTime());
    }
}
