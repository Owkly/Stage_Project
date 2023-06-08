package com.clinkast.stageproject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
// Connetion DriverManager Statement ResulSet SQLException

public class DataConnection {
    public static void main(String[] args) {

        // Vérification de la connection à la base de donnée MySql

        try (Connection conn = DriverManager.getConnection(PropertieMySQL.url, PropertieMySQL.user, PropertieMySQL.password)) {
            System.out.println("Connected to the database");

            String sql = "SELECT * FROM stop";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Objet htmlContent
            StringBuilder htmlContent = new StringBuilder();
            htmlContent.append("<html><body><table>");

            // Header row
            htmlContent.append("<tr><th>Id</th><th>Stop Name</th><th>Previous Stop</th><th>Next Stop</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String stopName = resultSet.getString("stopName");
                String previousStop = resultSet.getString("previousStop");
                String nextStop = resultSet.getString("nextStop");
                htmlContent.append("<tr>")
                        .append("<td>").append(id).append("</td>")
                        .append("<td>").append(stopName).append("</td>")
                        .append("<td>").append(previousStop != null ? previousStop : "").append("</td>")
                        .append("<td>").append(nextStop != null ? nextStop : "").append("</td>")
                        .append("</tr>");
            }

            htmlContent.append("</table></body></html>");

            // Write HTML content to file
            FileWriter fileWriter = new FileWriter(HTMLPath.url);
            fileWriter.write(htmlContent.toString());
            fileWriter.close();

            System.out.println("HTML file generated successfully.");

        } catch (SQLException | IOException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}

