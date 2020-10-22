package com.bksoftwarevn.itstudent.controller.pack_request_dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LearnSendRedirect", value = "/learn-send-redirect")
public class LearnSendRedirect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 chơ chế điều hướng request là chuyển sang trang khác cả tài nguyên ở trong server
        //và ngoài server
        response.sendRedirect("test-request-dispatcher");
    }
}
