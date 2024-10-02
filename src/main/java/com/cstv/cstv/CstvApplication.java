package com.cstv.cstv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CstvApplication {
	private static Logger logger = LoggerFactory.getLogger(CstvApplication.class);
	public static void main(String[] args) {
		//logger.warn("Prueba de warn");
		SpringApplication.run(CstvApplication.class, args);
	}
	//logger.warn("mensaje);

}
