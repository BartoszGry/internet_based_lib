package com.grygierczyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.grygierczyk")
public class SystemBibliotekiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemBibliotekiApplication.class, args);
	}

}
