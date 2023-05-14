package com.JoysToysApplication.JoysToysApplication.DTO;

public class AuthToken {

    private String token;
    private String username;

    public AuthToken(){

    }

    public AuthToken(String token, String username){
        this.token = token;
        this.username = username;
    }

    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public static AuthToken createGarbageAuthToken() {
        // Create a dummy or default AuthToken with garbage values
        AuthToken garbageAuthToken = new AuthToken();
        garbageAuthToken.setToken("garbage-token");
        garbageAuthToken.setUsername(null); // or some invalid value

        return garbageAuthToken;
    }


}
