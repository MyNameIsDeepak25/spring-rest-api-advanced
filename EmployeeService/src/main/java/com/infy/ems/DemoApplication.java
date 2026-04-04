package com.infy.ems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.infy.ems.security.User;
import com.infy.ems.security.UserRepository;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
    CommandLineRunner run(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            User user = new User();
            user.setUsername("deepak");
            user.setPassword(encoder.encode("1234"));
            user.setRole("ROLE_USER");
            repo.save(user);
        };
    }

}
