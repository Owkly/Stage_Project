package com.clinkast.stageproject.data;

import com.clinkast.stageproject.HTMLPath;
import com.clinkast.stageproject.PropertieMySQL;
import com.clinkast.stageproject.data.model.FileWriterUtil;
import com.clinkast.stageproject.data.model.HtmlGenerator;

import java.sql.*;

public class DataConnectionv2 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(PropertieMySQL.url, PropertieMySQL.user, PropertieMySQL.password)) {
            System.out.println("Connected to the database");

            String sql = "SELECT * FROM stop";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            String htmlContent = HtmlGenerator.generateHtmlContent(resultSet);
            FileWriterUtil.writeHtmlToFile(htmlContent, HTMLPath.url);

        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}
