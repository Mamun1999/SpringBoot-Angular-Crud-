package com.mamun.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mamun.post.Util.JwtUtil;
import com.mamun.post.model.JwtRequest;
import com.mamun.post.model.JwtResponse;
//first time we creating jwt token
//validating user first with the help of auhentication manager
@RestController
public class JwtController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    
     @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        

        System.out.println(jwtRequest);

       try {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

       } catch (UsernameNotFoundException e) {
         e.printStackTrace();
         throw new Exception("bad Credentials");
       }

//after authentication is successfull
//now get the user details for creating jwt token 
UserDetails userdetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());

//we are going to generate token

String token =this.jwtUtil.generateToken(userdetails);
System.out.println("JWT token : "+token);

// token generated and now we send back the token to the client
//for this we have to convert it into JSON

return ResponseEntity.ok(new JwtResponse(token));
    }
}
