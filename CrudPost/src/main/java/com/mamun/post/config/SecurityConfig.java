package com.mamun.post.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import com.mamun.post.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Autowired
private CustomUserDetailsService customUserDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    public DaoAuthenticationConfigurer<AuthenticationManagerBuilder, CustomUserDetailsService> configSecurityFilterChain(AuthenticationManagerBuilder auth) throws Exception{
//     return auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }

@Bean
public AuthenticationManager authenticationManagerbean(AuthenticationConfiguration configuration) throws Exception{

    return configuration.getAuthenticationManager();

}



@Bean
public AuthenticationProvider daoAuthenticationProvider(){
     DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
     provider.setUserDetailsService(customUserDetailsService);
     provider.setPasswordEncoder(passwordEncoder());
     return provider;

     //authentication done
}

    //  @Bean
    // public UserDetailsService userDetailsService(){

    //          UserDetails normallUser=User.withUsername("mamun").password(passwordEncoder().encode("12345")).roles("NORMAL").build();


    //          UserDetails admin=User.withUsername("naim").password(passwordEncoder().encode("123")).roles("ADMIN").build();

    //          return new InMemoryUserDetailsManager(normallUser,admin);

    // }

    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        
        httpSecurity.csrf().disable()
              .authorizeHttpRequests()
                .requestMatchers("/token")
              
              
             .permitAll()

              
                  .requestMatchers("/api/**")
                 .hasRole("ADMIN")
            
                 
                 
                .requestMatchers("/user/**")
               .hasRole("NORMAL")
            
              
              
    
              .anyRequest()
              .authenticated()

              .and()
              .httpBasic();
              httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

              
              httpSecurity.authenticationProvider(daoAuthenticationProvider());

    DefaultSecurityFilterChain defaultSecurityFilterChain=httpSecurity.build();
    return defaultSecurityFilterChain;

        
            
             
             
    }

 
}
