package view;

import dao.CategoryDao;
import dao_impl.CategoryDaoImpl;
import model.Category;
import model.MyConnection;

import javax.print.attribute.standard.PagesPerMinute;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        try {
            myConnection.connectDB();
            CategoryDao categoryDao = new CategoryDaoImpl();
            List<Category> list =  categoryDao.findAll();
            for(Category c : list) System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
