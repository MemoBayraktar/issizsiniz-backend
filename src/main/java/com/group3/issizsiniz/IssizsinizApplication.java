package com.group3.issizsiniz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class IssizsinizApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssizsinizApplication.class, args);
	}

}
