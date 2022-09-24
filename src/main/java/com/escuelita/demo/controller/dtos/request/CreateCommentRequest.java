package com.escuelita.demo.controller.dtos.request;

public class CreateCommentRequest {
    private String content;
    private String author;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
