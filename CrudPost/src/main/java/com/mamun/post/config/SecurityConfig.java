package com.mamun.post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

     @Bean
    public UserDetailsService userDetailsService(){

             UserDetails normallUser=User.withUsername("mamun").password(passwordEncoder().encode("12345")).roles("NORMAL").build();


             UserDetails admin=User.withUsername("naim").password(passwordEncoder().encode("123")).roles("ADMIN").build();

             return new InMemoryUserDetailsManager(normallUser,admin);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        
        httpSecurity.csrf().disable()
              .authorizeHttpRequests()
            //   .requestMatchers("/home/api/**")
            //   .hasRole("ADMIN")
            //   .requestMatchers("/home/user/**")
            //   .hasRole("NORMAL")
            //   .requestMatchers("/login","/home")
              
            //   .permitAll()
              
              
           
              .anyRequest()
              .authenticated()

              .and()
              .httpBasic();


    return httpSecurity.build();

        
            
             
             
    }
}
