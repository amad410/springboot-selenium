package com.test.SpringTestFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringTestFrameworkApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringTestFrameworkApplication.class, args);
	}

}
