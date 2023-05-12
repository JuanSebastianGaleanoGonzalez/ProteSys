package com.protesys.model;

public class Credencial {
    private String username;
    private String password;

    //CONSTRUCTOR
    public Credencial(){}

    public Credencial(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //ACCESSORS
    
    //GETTER
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //SETTER

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    };

    //METHOD
}
