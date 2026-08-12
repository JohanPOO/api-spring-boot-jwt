package com.api.auth;

public class LoginRequest {

    private String username;
    private String contraseña;

    public LoginRequest(){
    }

    public LoginRequest(String username, String contraseña){
        this.username = username;
        this.contraseña = contraseña;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
