package com.clinkast.stageproject.controller;

import com.clinkast.stageproject.data.StopRepository;
import com.clinkast.stageproject.data.model.Stop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("stops")
public class StopContoller {

    private final StopRepository stopRepository;

    public StopContoller(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Stop> getStops() throws SQLException {
      return  stopRepository.findStops();
    }

}
