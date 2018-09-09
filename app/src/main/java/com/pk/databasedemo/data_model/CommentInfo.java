package com.pk.databasedemo.data_model;

public class CommentInfo {
    private int c_id, id;
    private String name, comment;

    public CommentInfo(int c_id, int id, String name, String comment) {
        this.c_id = c_id;
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public CommentInfo(int id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
