package com.clinkast.stageproject.model;

public class Stop {

    private int id;

    private String stopName;

    private String previousStop;

    private  String nextStop;

    public Stop(int id, String stopName, String previousStop, String nextStop) {
        this.id = id;
        this.stopName = stopName;
        this.previousStop = previousStop;
        this.nextStop = nextStop;
    }

    public int getId() {
        return id;
    }

    public String getStopName() {
        return stopName;
    }

    public String getPreviousStop() {
        return previousStop;
    }

    public String getNextStop() {
        return nextStop;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public void setPreviousStop(String previousStop) {
        this.previousStop = previousStop;
    }

    public void setNextStop(String nextStop) {
        this.nextStop = nextStop;
    }
}
