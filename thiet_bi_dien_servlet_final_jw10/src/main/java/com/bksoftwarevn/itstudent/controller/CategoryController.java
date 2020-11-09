package com.bksoftwarevn.itstudent.controller;

import com.bksoftwarevn.itstudent.model.Category;
import com.bksoftwarevn.itstudent.model.JsonResult;
import com.bksoftwarevn.itstudent.service.CategoryService;
import com.bksoftwarevn.itstudent.service_impl.CategoryServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/api/v1/category/*")
public class CategoryController extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    private JsonResult jsonResult = new JsonResult();

    private Gson gson = new Gson();

    //xử lý những api thêm dữ liệu
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //xử lý api liên quan đến thêm một bản ghi category
        String rs = null;
        try {
            //hàm insert cần truyền vào một đối tượng Category
            // thì đốii tượng category là dữ liệu mà người dùng cần truyền lên cho mình

            //Cách truyền dữ liêu từ client server
            /**
             * C1: truyền qua param, các thông của người dùng đượ truyền lên bằng queryString: key=value
             *   value: String, không thể truyền đới tượng
             * C2: truyền thông tin qua body
             *      - chỉ có trong cá method PUT, POST, DELETE;
             *      - Có thẻ truyền đối tượng
             */
            //hướng dẫn lấy thông tin từ body
            //chuyển một chuỗi json thành một đối tượng nhờ thư viện gson

            //tham số đầu tiên của hàm fromJson có thể là 1 chuỗi json, hoặc là 1 bộ đọc để đọc chuỗi json
            //request.getReeader() chính là bọc đọc dùng để đọc thông tin người dùng truyền vào body.
            Category category = gson.fromJson(request.getReader(),Category.class);
            rs = gson.toJson(jsonResult.jsonSuccess(categoryService.insert(category)));
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = gson.toJson(jsonResult.jsonFail("Thêm category thất bại"));
        }
        response.getWriter().println(rs);
    }

    //xử lý những api tìm kiếm dữ liệu
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //controller => service => dao
        /**
         * Đối với tìm kiếm dữ liệu trong service cung cấp 2 hàm
         *      - findAll
         *      - findById
         *  - api/v1/category/find-all => findAll
         *  - api/v1/categroy/find-by-id => findById
         */
        String pathInfo = request.getPathInfo();
        String rs = null;
        if(pathInfo.equals("/find-all")) {
            //gọi đến service findAll của category để lấy ra kết quả
            try {
                List<Category> list = categoryService.findAll();
                rs = gson.toJson(jsonResult.jsonSuccess(list));
            } catch (Exception ex){
                ex.printStackTrace();
                rs = gson.toJson(jsonResult.jsonFail("category find all fail"));
                //kết quả trả về luôn trả một chuỗi
                //client không nhận biết được đây là thông thực
                //hiện thành công hay là lỗi
                //để thể hiện api trả về đúng thông tin thì cần
                //ngoài chuỗi trả về thì cần thêm một trường
                //để người dùng biết được là success, fail
            }
        } else if(pathInfo.equals("/find-by-id")) {
            //gọi đến service findById
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Category category = categoryService.findById(id);
                rs = gson.toJson(jsonResult.jsonSuccess(category == null ? "" : category));
            } catch (Exception ex) {
                ex.printStackTrace();
                rs = gson.toJson(jsonResult.jsonFail("category find by id fail"));
            }
        } else {
            //404
            //int status nó là Http status code
            response.sendError(404, "Not Found");
        }
        response.getWriter().println(rs);
    }

    //xử lý những api xóa dữ liệu
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //gọi đến service xóa category
        //tham số đầu vào của hàm delte chỉ là id int
        //chỉ cần lấy thông tìn bằng param
        String rs = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            rs = gson.toJson(jsonResult.jsonSuccess(categoryService.delete(id)));
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = gson.toJson(jsonResult.jsonFail("Xóa category lỗi!"));
        }
        response.getWriter().println(rs);
    }

    //xử lý những api xử dữ liệu
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //sẽ gọi đến hàm update trong service
        //hàm update trong service cần truyền vào tham số gì,
        //trả về cho mình tham số gì
        //ở thám số truyenef vào khác gì so với tham số truyền
        //vào ở hàm insert
        //phải sử dụng thuyền thông tin bằng body
        String rs = null;
        try {
            Category category = gson.fromJson(request.getReader(), Category.class);
            rs = gson.toJson(jsonResult.jsonSuccess(categoryService.update(category)));
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = gson.toJson(jsonResult.jsonFail("Sửa category lỗi!"));
        }
        response.getWriter().println(rs);
    }
}
