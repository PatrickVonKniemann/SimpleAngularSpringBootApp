package com.example.demoapi.Models.Dtos;

public class NoteCreateDTO {
    private String content;
    private Long appUserId;

    public NoteCreateDTO(String content, Long appUserId) {
        this.content = content;
        this.appUserId = appUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }
}
