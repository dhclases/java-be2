package com.dh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class App {
	private static final Logger logger = LogManager.getLogger(App.class);
	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		SpringApplication.run(App.class, args);
	}

}
