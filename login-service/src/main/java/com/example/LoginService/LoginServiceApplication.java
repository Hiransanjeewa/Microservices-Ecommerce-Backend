package com.example.LoginService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

//import com.example.sharedlibrary.*;


@SpringBootApplication
@Component
public class LoginServiceApplication {

	@Value("${common.LoginUser2.username}")
	private static String username;



	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
		System.out.println(username);
	}

}
