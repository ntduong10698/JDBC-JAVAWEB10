package view;

import model.MyConnection;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        try {
            myConnection.connectDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
