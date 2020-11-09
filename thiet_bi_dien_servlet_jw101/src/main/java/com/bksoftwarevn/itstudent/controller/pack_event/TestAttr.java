package com.bksoftwarevn.itstudent.controller.pack_event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestAttr", value = "/test-attr")
public class TestAttr extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //thêm một attr
        request.setAttribute("test-attr", "1");
        //xóa một attr
        request.removeAttribute("test-attr");
        //sửa một attr
        request.setAttribute("test-attr", "2");
        //Cơ chế sửa và thêm một attr được thực hiện như nào
        //THêm và sửa attr đều được thực hiện bởi một hàm setAttr, nếu key chưa tồn tại thì sẽ thực
        //thêm còn đã tồn tại sẽ thực hiện sửa
        
    }
}
