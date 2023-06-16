package com.clinkast.stageproject.data;

import com.clinkast.stageproject.PropertieMySQL;
import org.springframework.stereotype.Component;

import java.sql.*;
// Connetion DriverManager Statement ResulSet SQLException


@Component
public class DataConnection {
    private Connection connection;

    public Connection openConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(PropertieMySQL.url, PropertieMySQL.user, PropertieMySQL.password);
        this.connection = connection;

        return connection;
    }

    public void closeConnection() throws SQLException {
       this.connection.close();
    }

}

