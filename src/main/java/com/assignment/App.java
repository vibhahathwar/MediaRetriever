package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * App class consists main method
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.assignment")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
