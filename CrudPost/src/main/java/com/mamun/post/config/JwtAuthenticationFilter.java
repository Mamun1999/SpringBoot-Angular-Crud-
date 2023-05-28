package com.mamun.post.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mamun.post.Util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//after client first time login a token will be generated and send to  client. 
// 2nd time when user come with token then user token will be validated in this class method  do Filternal internal
// after successfull token checking then rquest will go to next step for accessing apis

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
           
                final String requestTokenHeader= request.getHeader("Authorization");
                System.out.println(requestTokenHeader);
                String username=null;
                String jwtToken=null;
             
                if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")){
                    jwtToken=requestTokenHeader.substring(7);//got token from header

                   //got token from Authorization
                    try {
                        username= this.jwtUtil.getUsernameFromToken(jwtToken);
                        //got username from token
                    } catch (Exception e) {
                       e.printStackTrace();
                        
                    }
                }
                    else{
                        System.out.println("jwt token does not start with bearer");
                    }
                
                    

                 
                  if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

                    UserDetails userDetails =  this.userDetailsService.loadUserByUsername(username);
                    //got userdetails(name ,pass, authority) from username
               // checking main security that things we got from token is right or not
               if(this.jwtUtil.validateToken(jwtToken,userDetails))

             
               
               {
                   //token is valid
                   //set authentication  in the securitycontextholder
                   UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                   usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                   SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
   
               }
                  }
                  else{
                    System.out.println("Token is not valid");
                  }

                  //if token is validated then request will go to apis

                  filterChain.doFilter(request, response);

                

               
       

       
    }
    
}
