package com.example.demoapi.Models.Dtos;

public class AppUserUpdateDTO {
    private String name;

    public AppUserUpdateDTO(Long id, String name) {

        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
