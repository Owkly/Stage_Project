package com.clinkast.stageproject.data.model;


public class Stop {
    private final String stopName;
    private final String previousStop;
    private final String nextStop;

    public Stop(String stopName, String previousStop, String nextStop) {
        this.stopName = stopName;
        this.previousStop = previousStop;
        this.nextStop = nextStop;
    }
}
