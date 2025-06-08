package com.grupo.gymSys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GymSysApplication {

	private static final Logger logger = LoggerFactory.getLogger(GymSysApplication.class);

	public static void main(String[] args) {
		logger.debug(">>> PRD PROFILE ACTIVE <<<");
		SpringApplication.run(GymSysApplication.class, args);
	}

}
