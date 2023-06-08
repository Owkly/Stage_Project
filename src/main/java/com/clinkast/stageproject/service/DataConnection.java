package com.clinkast.stageproject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
// Connetion DriverManager Statement ResulSet SQLException


@Service
public class DataConnection {

    @Value("${mysql.url}")
    public  String url ;
    @Value("${mysql.user}")
    public  String user;
    //public static String password = "stage"; // mdp Yannick
    @Value("${mysql.password}")
    public  String password; // mdp Steeve

    public Connection getConnection() throws SQLException {
        System.out.println("Connected to the database");
        Connection  conn = DriverManager.getConnection(url, user, password);
        return conn;
    }


}

