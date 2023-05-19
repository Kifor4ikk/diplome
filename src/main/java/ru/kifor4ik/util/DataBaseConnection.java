package ru.kifor4ik.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {


    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/diplome";
    private static final String username = "admin";
    private static final String password = "1";


    public static Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
        System.out.println("Connected with " + jdbcUrl + "!");
        return connection;
    }
}
