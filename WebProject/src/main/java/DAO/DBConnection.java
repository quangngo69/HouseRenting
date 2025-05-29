package DAO;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/HouseRenting";
    private static final String USER = "root";
    private static final String PASSWORD = "Ccxinh2004";

    static {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
        
    }
    
}
