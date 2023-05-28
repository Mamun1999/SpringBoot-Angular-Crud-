package com.mamun.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mamun.post.model.User;
import com.mamun.post.repo.UserRepo;

@SpringBootApplication
public class CrudPostApplication implements CommandLineRunner {

    @Autowired
	private UserRepo userRepo;
    @Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {

		SpringApplication.run(CrudPostApplication.class, args);


 
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		

		// User user1=new User();
		// user1.setUsername("mamun");
		// user1.setEmail("mamun@gmail.com");
		// user1.setPassword(this.bCryptPasswordEncoder.encode("12345"));;
		// user1.setRole("ROLE_ADMIN");
		// this.userRepo.save(user1);

		// User user2=new User();
		// user2.setUsername("naim");
		// user2.setEmail("naim@gmail.com");
		// user2.setPassword(this.bCryptPasswordEncoder.encode("123"));;
		// user2.setRole("ROLE_NORMAL");
		// this.userRepo.save(user2);


	}


	
// 	@Bean
// 	public WebMvcConfigurer corsConfigurer(){
    
// 		return new WebMvcConfigurer() {
// 			@Override
// 			public void addCorsMappings(CorsRegistry registry) {
// 				registry.addMapping("/**")
// 					.allowedOrigins("http://localhost:4200"); // Add the allowed origin(s) for your Angular application
// 					// .allowedMethods("GET", "POST", "PUT", "DELETE") // Add the allowed HTTP methods
// 					// .allowedHeaders("*") // Add the allowed headers
// 					// .allowCredentials(true); // Allow sending cookies along with the request
// 			}
// 		};
// }


}
