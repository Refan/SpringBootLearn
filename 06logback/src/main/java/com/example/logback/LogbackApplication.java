package com.example.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling    //定時任務的註解
public class LogbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogbackApplication.class, args);
	}
}
