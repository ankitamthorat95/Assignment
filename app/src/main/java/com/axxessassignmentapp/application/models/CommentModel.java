package com.axxessassignmentapp.application.models;

public class CommentModel {
    int id;
    String imageid;
    String comment;

    public CommentModel() {
    }

    public CommentModel(int id, String imageid, String comment) {
        this.id = id;
        this.imageid = imageid;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
