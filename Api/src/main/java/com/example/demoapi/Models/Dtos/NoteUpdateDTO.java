package com.example.demoapi.Models.Dtos;

public class NoteUpdateDTO {

    private String content;

    public NoteUpdateDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
