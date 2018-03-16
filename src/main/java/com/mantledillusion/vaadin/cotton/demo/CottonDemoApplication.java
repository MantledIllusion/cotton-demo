package com.mantledillusion.vaadin.cotton.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CottonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CottonDemoApplication.class, args);
	}
}
