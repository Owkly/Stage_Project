package com.clinkast.stageproject.data;

import com.clinkast.stageproject.data.model.Stop;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class StopRepository {
    private final DataConnection dataConnection;

    private static final String sql = "SELECT * FROM stop";

    public StopRepository(DataConnection dataConnection) {
        this.dataConnection = dataConnection;
    }

    public List<Stop> findStops() throws SQLException {
        List<Stop> stops = new ArrayList<>();
        try {
            Connection connection = dataConnection.openConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String stopName = resultSet.getString("stopName");
                String previousStop = resultSet.getString("previousStop");
                String nextStop = resultSet.getString("nextStop");
                stops.add(new Stop(stopName, previousStop, nextStop));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dataConnection.closeConnection();
        }

        return stops;
    }
}
