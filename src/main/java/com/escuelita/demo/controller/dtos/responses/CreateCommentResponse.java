package com.escuelita.demo.controller.dtos.responses;

public class CreateCommentResponse {
    private Long id;
    private String content;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
