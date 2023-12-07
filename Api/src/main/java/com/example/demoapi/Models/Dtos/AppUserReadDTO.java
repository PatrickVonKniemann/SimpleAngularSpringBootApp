package com.example.demoapi.Models.Dtos;

import java.util.List;

public class AppUserReadDTO {
    private Long id;
    private String name;
    private List<NoteReadDTO> notes;

    public AppUserReadDTO() {
    }

    public AppUserReadDTO(Long id, String name, List<NoteReadDTO> notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NoteReadDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteReadDTO> notes) {
        this.notes = notes;
    }
}
