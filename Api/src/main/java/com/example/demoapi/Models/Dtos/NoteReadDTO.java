package com.example.demoapi.Models.Dtos;

public class NoteReadDTO {
    private Long id;
    private String content;
    private Long appUserId;

    public NoteReadDTO() {

    }

    public NoteReadDTO(Long id, String content, Long appUserId) {
        this.id = id;
        this.content = content;
        this.appUserId = appUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
