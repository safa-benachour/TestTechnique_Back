package com.example.product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.product")
public class TestTechniqueApplication {

	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(TestTechniqueApplication.class, args);
	}

}
