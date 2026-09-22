package es.cursospring.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursospring.springcore.config.Config05;
import es.cursospring.springcore.service.Servicio1;

public class App05 {
	public static void main(String[] args) {
		
		try (var ctx = new AnnotationConfigApplicationContext(Config05.class)) {
			
			Servicio1 scio = ctx.getBean(Servicio1.class);
			scio.servicio();
		}
	}
}
