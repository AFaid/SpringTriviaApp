package com.springproject.SpringTriviaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TriviaAppApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(TriviaAppApplication.class, args);
	}

}
