package com.example.isabelmelo.todolist.User;

public class UserModel {
    private String Username;
    private String name;
    private String password;

    public String getUsername() {
        return Username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}