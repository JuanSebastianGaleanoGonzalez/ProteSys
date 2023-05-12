package com.protesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ProteSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProteSysApplication.class, args);
	}

}
