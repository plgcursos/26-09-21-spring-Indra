package es.cursospring.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.cursospring.springcore.service.Servicio1;
import es.cursospring.springcore.service.Servicio1Impl;

//@Configuration
public class Config02 {

	@Bean
	public Servicio1 servicio1() {
		Servicio1Impl bean = new Servicio1Impl(null);
		bean.setMensaje("Mensaje creado en JavaConfig");
		return bean;
	}
}
