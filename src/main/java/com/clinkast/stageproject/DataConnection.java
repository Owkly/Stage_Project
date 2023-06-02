package com.clinkast.stageproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/MySQLConnection";
        String user = "root";
        String password = "stage";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}
