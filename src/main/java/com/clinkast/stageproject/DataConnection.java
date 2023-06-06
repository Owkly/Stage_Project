package com.clinkast.stageproject;

import java.sql.*;
// Connetion DriverManager Statement ResulSet SQLException

public class DataConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/metro";
        String user = "root";
        String password = "stage";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database");

            String sql = "SELECT * FROM stop";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String stopName = resultSet.getString("stopName");
                String previousStop = resultSet.getString("previousStop");
                String nextStop = resultSet.getString("nextStop");
                System.out.println("Id : " + id);
                System.out.println("Stop Name : " + stopName);
                System.out.println("Previous Stop : " + previousStop);
                System.out.println("Next Stop : " + nextStop);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}

