package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "6n67aho3";
    public Connection getConnection() {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            //System.out.println("connection OK");
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("connection ERROR");
        }
        return connection;
    }

    // реализуйте настройку соеденения с БД
}
