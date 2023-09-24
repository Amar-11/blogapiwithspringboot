package com.amar.blogappapis;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogingAppsApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogingAppsApisApplication.class, args);
	}
	
	//using model mapper to convert DTO.
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

}
