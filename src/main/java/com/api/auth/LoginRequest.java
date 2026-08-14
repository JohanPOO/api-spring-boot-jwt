package com.api.auth;

public class LoginRequest {

    private String username;
    private String contrasena;

    public LoginRequest(){
    }

    public LoginRequest(String username, String contrasena){
        this.username = username;
        this.contrasena = contrasena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", contraseña='" + contrasena + '\'' +
                '}';
    }
}
