package com.ans.funstuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ans.funstuff.beans")
public class FunstuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunstuffApplication.class, args);
	}

}
