package com.dred.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class WebSpringBasicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringBasicoApplication.class, args);
	}

}
