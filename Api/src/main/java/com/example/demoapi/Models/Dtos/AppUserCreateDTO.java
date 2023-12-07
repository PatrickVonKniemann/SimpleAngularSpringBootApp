package com.example.demoapi.Models.Dtos;

public class AppUserCreateDTO {
    private String name;
    private String password;

    public AppUserCreateDTO() {
    }
    public AppUserCreateDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
