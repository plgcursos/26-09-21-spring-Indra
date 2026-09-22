package es.cursospring.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class S05SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05SpringbootWebApplication.class, args);
	}

}
