package com.bksoftwarevn.itstudent.controller.pack_event;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 * HttpSessionEvent là sự kiện dành cho đối tượng HttpSession
 * Cung cấp cho mình 2 sự kiện:
 *      + Create Session
 *      + Destroy Session
 * Về nhà tìm hiểu HttpSessionEvent cho mình làm gì?
 */
@WebListener
public class LearnHttpSessionEvent implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Create Session: " + new Date().getTime());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
