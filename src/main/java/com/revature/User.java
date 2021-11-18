package com.revature;

import java.beans.ConstructorProperties;

public class User {

    private int ps_id;
    private String username;
    private String password;

    @ConstructorProperties({"ps_id", "username", "password"})
    public User(int ps_id, String username) {
        this.ps_id = ps_id;
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPs_id() {
        return this.ps_id;
    }
}
