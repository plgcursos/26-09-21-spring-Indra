package es.cursospring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan //activa la búsqueda de @ConfigurationProperties
public class S03SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(S03SpringbootApplication.class, args);
	}

}
