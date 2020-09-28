package model;

import common.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static Connection connection = null;

    /**
     * Các bước để kết nối đến database
     * B1: Kiểm tra dirver jdbc đã tồn tại hay chưa bằng hàm driverTest();
     * B2: thực hiện kết nối với db bằng hàm connectDB cần có các tham số đầu vào url, username, passowrd;
     * B3: Dùng prepar và pareparUpdate để thực hiện các câu lệnh thao tác với db
     * B4: đóng kết nối
     * */

    public void driverTest() throws ClassNotFoundException{
        try {
            Class.forName(AppConfig.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("JDBC Driver not found" + e.getMessage());
        }
    }

    public Connection connectDB() throws ClassNotFoundException, SQLException{
        driverTest();
//        thực hiện kết nôi và lấy ra đối tượng connection
        try {
            connection = DriverManager.getConnection(AppConfig.URL_DATABASE, AppConfig.USERNAME, AppConfig.PASSWORD);
            if(connection != null) System.out.println("Connect DB successfully");
        } catch (SQLException e) {
            throw new SQLException("Connect DB fail " + e.getMessage());
        }
        return  connection;
    }
}
