package es.cursospring.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.cursospring.springcore.service.Servicio1;
import es.cursospring.springcore.service.Servicio1Impl;

//@Configuration
public class Config01 {

	@Bean
	public Servicio1 servicio1() {
		return new Servicio1Impl(null);
	}
}
