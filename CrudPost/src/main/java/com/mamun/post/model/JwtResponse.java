package com.mamun.post.model;
//user will get the response with token after successful login
public class JwtResponse {

    private String token;
    

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
