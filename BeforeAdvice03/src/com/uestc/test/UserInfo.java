package com.uestc.test;
public class UserInfo {
    private String username;
    private String password;

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }
}
