package com.service.Glib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GlibApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlibApplication.class, args);
	}

}
