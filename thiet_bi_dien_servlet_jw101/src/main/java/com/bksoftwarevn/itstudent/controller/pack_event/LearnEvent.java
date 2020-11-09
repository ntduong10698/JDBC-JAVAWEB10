package com.bksoftwarevn.itstudent.controller.pack_event;

/**
 * Các vấn đề chung trong event:
 * + Event là một việc có khả năng xảy ra trong hệ thống
 *      Ví dụ: thay đổi thuộc tính của một đối tượng có thể được xem là một sư kiện
 *      => Khi xảy ra suwk kiện thì sẽ làm gì với sự kiện kiện đấy. Khi mà mình thay đổi thuộc tính
 *      của một đối tượng thì mình sẽ thông báo thuộc tình được thay thành công và thời gian thay đổi thuộc
 *      tính đấy là bao lâu
 *      => Để làm được điều này thì song song mỗi Event thì sé có một Listener tương ứng
 * + Listener: có nhiệm vụ kiểm tra khi nào event tương ứng của nó xảy ra và xảy ra thì sẽ xử lý như thế nào
 * => Khi tìm hiểu về event thì mình sẽ tìm hình event đấy là gì và Listener nào
 * sẽ giải  quyết event đó
 */

/**
 * Event trong servlet:
 *      + ServletRequestEvent - ServletRequestListner
 *      + ServletContextEvent - ServletContextListner
 *      + ServletRequestAttributeEvent
 *      + ServletContexAttributeEvent
 *      + HttpSessionEvent
 *      + HttpSessionBindingEvent
 * => ServletRequestEvent, ServletRequestAttributeEvent, HttpSessionEvent
 *
 * => Khi àm việc với event thì các bạn sẽ làm việc với Listener tương ứng
 */
public class LearnEvent {
}
