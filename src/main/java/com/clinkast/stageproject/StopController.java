package com.clinkast.stageproject;


import com.clinkast.stageproject.model.Stop;
import com.clinkast.stageproject.service.DataConnection;
import com.clinkast.stageproject.service.StopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
public class StopController {
    private final StopService stopService;
    private final DataConnection dataConnection;

    public StopController(StopService stopService, DataConnection dataConnection) {
        this.stopService = stopService;
        this.dataConnection = dataConnection;
    }

    @GetMapping("/stops")
    List<Stop> allStops() throws SQLException {
        Connection connection =  dataConnection.getConnection();
        return stopService.getStops(connection);
    }


}
