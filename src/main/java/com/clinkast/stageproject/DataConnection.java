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
            htmlContent.append("<!DOCTYPE html>\n<html>\n<head>\n");

            // Header row
            htmlContent.append("<title>Présentation des arrêts</title>\n" +
                    "  <meta charset=\"UTF-8\">\n" +
                    "  <style>\n" +
                    "   table {\n" +
                    "       border-collapse: collapse;\n" +
                    "       width: 100%;\n" +
                    "   }\n" +
                    "   th, td {\n" +
                    "       border: 1px solid black;\n" +
                    "       padding: 8px;\n" +
                    "       text-align: center;\n" +
                    "   }\n" +
                    "   th {\n" +
                    "       background-color: #f2f2f2;\n" +
                    "   }\n" +
                            "   .centered-title {\n" +
                            "      text-align: center;\n" +
                            "       color: red;\n" +
                            "    }\n" +
                    "   </style>\n" +
                    "</head>\n"
                    );

            // Body row
            htmlContent.append("<body>\n" +
                    "   <h1 class='centered-title'>Présentation des arrêts</h1>\n" +
                    "   <table>\n" +
                    "   <tr>\n" +
                    "       <th>ID</th>\n" +
                    "       <th>Arrêt</th>\n" +
                    "       <th>Arrêt précédent</th>\n" +
                    "       <th>Arrêt suivant</th>\n" +
                    "   </tr>\n");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String stopName = resultSet.getString("stopName");
                String previousStop = resultSet.getString("previousStop");
                String nextStop = resultSet.getString("nextStop");
                htmlContent.append("<tr>\n")
                        .append("<td>").append(id).append("</td>\n")
                        .append("<td>").append(stopName).append("</td>\n")
                        .append("<td>").append(previousStop != null ? previousStop : "").append("</td>\n")
                        .append("<td>").append(nextStop != null ? nextStop : "").append("</td>\n")
                        .append("</tr>\n");
            }

            htmlContent.append("</table>\n</body>\n</html>");

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

