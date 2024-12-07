package com.app.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TodoappApplication {

	public static void main(String[] args) {

		SpringApplication.run(TodoappApplication.class, args);

		System.out.println("Hello World!");

	}

	@GetMapping("/")
	public String home() {
		System.out.println("Home method called"); // This should print to console
		return "home";
	}

}
