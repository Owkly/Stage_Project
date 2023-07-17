package com.clinkast.stageproject.data.model;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {
    public static void writeHtmlToFile(String htmlContent, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(htmlContent);
            fileWriter.close();
            System.out.println("HTML file generated successfully.");
        } catch (IOException e) {
            System.out.println("Failed to write HTML content to the file");
            e.printStackTrace();
        }
    }
}
