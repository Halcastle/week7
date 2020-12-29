package com.geekStudy.week7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.geekStudy.week7.config.DynamicDataSourceRegister;

@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
public class Week7Application {

	public static void main(String[] args) {
		SpringApplication.run(Week7Application.class, args);
	}

}
