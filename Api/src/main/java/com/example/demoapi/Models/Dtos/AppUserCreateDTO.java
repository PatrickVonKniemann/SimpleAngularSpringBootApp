package com.example.demoapi.Models.Dtos;

public class AppUserCreateDTO {
    private String name;

    public AppUserCreateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
