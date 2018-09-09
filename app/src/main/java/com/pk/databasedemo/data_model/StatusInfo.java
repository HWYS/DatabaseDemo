package com.pk.databasedemo.data_model;

public class StatusInfo {
    private int id;
    private String name, status;

    public StatusInfo(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public StatusInfo(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
