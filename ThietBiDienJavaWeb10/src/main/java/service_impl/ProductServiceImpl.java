package service_impl;

import dao.ProductDao;
import dao_impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    public List<Product> sortBy(String field, boolean isASC) throws SQLException {
        //chỉ cho phép người dùng sắp xếp theo các trường sau
        //nếu người dùng nhập đúng các chuỗi tương ứng ở dưới thì gọi hàm
        //đẻ thực hiện câu lệnh sắp xếp còn nhập vào một chuỗi khác thì sẽ trả về null
        //price
        //guaranteee
        //bought
        //create_time
        //promotion
        String[] listField = {"price", "guaranteee", "bought", "create_time", "promotion"};
        boolean check = false;
        for (String s: listField) {
           if(s.equals(field)) {
               check = true;
               break;
           }
        }
        return check ? productDao.sortBy(field, isASC): null;
    }

    public List<Product> findByCategory(int idCategory) throws SQLException {
        return null;
    }

    public List<Product> search(String name, String startDate, String endDate, Boolean soldOut, int guarantee, int categoryId, int bought, int promotion) throws SQLException {
        return null;
    }

    public List<Product> findAll() throws SQLException {
        return null;
    }

    public Product findById(int id) throws SQLException {
        return null;
    }

    public Product insert(Product product) throws SQLException {
        return null;
    }

    public boolean update(Product product) throws SQLException {
        return false;
    }

    public boolean delete(int id) throws SQLException {
        return false;
    }
}
