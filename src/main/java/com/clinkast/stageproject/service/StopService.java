package com.clinkast.stageproject.service;

import com.clinkast.stageproject.model.Stop;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class StopService {
    private static final String QUERY = "SELECT * FROM stop" ;

    public List<Stop> getStops(Connection conn) throws SQLException {
        List<Stop> stops = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY);

        while (resultSet.next()) {
            int id = resultSet.getInt("Id");
            String stopName = resultSet.getString("stopName");
            String previousStop = resultSet.getString("previousStop");
            String nextStop = resultSet.getString("nextStop");
            Stop stop = new Stop(id,stopName, previousStop, nextStop);
            stops.add(stop);
        }

        return stops;
    }
}
