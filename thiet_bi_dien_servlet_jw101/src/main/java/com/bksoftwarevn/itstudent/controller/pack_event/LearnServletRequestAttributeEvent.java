package com.bksoftwarevn.itstudent.controller.pack_event;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;


/**
 * ServlerRequestAttributeEvent là các sư kiện về đối tượng RequestAttribute
 * Cung cấp 3 sự kiện:
 *      + Thêm một attribute
 *      + Xóa một attribute
 *      + Sửa một attribute
 * Tương ứng với 3 sự kiện trên sẽ có 3 hàm tương ứng và đầu vào của 3 hàm đều là đối tượng
 * ServletRequestAttributeEvent cho phép mình lấy ra đối tượng ServletRequest bằng hàm
 * getServletRequest
 * => Đẻ demo với 3 sự kiện này thì phải tạo ra một servlet có chức năng thêm, sủa, xóa attr
 */
@WebListener
public class LearnServletRequestAttributeEvent implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        //Lấy ra đối tượng ServletRequest
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        //System.out.println("Add attr: "+ servletRequest.getAttribute("test-attr") + "-" + new Date().getTime());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        //System.out.println("Remove attr: "+ servletRequest.getAttribute("test-attr") + "-" + new Date().getTime());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        //mặc định khi request đến một url luôn in ra một Repace attr: null, tìm hiểu xem vì sao lại như thế
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        //System.out.println("Replace attr: "+ servletRequest.getAttribute("test-attr") + "-" + new Date().getTime());
    }
}
