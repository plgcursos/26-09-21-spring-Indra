package es.cursospring.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursospring.springcore.config.Config02;
import es.cursospring.springcore.service.Servicio1;

public class App02 {
	public static void main(String[] args) {
		
		try (var ctx = new AnnotationConfigApplicationContext(Config02.class)){
			
			Servicio1 scio = ctx.getBean("servicio1", Servicio1.class);
//			scio.servicio();
			System.out.println(scio.getMensaje());
		}
		
	}
}
