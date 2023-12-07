package com.example.demoapi.Models;

import java.util.List;

public class AppUserReadDTO {
    private Long id;
    private String name;
    private List<Long> noteIds; // Assuming you only want to send note IDs

    public AppUserReadDTO(Long id, String name, List<Long> noteIds) {
        this.id = id;
        this.name = name;
        this.noteIds = noteIds;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Long> getNoteIds() {
        return noteIds;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoteIds(List<Long> noteIds) {
        this.noteIds = noteIds;
    }
}
