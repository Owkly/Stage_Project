package com.clinkast.stageproject.data.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HtmlGenerator {
    public static String generateHtmlContent(ResultSet resultSet) throws SQLException {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n<html>\n<head>\n");
        // Reste du code de génération du fichier HTML

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
        return htmlContent.toString();
    }
}
