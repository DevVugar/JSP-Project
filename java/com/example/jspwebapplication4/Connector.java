package com.example.jspwebapplication4;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbcdb";
        String username = "root";
        String password = "root1234";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
