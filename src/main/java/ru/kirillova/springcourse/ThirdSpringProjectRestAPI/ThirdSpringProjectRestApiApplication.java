package ru.kirillova.springcourse.ThirdSpringProjectRestAPI;

import org.modelmapper.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class ThirdSpringProjectRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdSpringProjectRestApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
