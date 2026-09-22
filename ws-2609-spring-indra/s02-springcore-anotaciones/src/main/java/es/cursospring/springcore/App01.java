package es.cursospring.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursospring.springcore.config.Config01;
import es.cursospring.springcore.service.Servicio1;

public class App01 {
	public static void main(String[] args) {
		
		try (var ctx = new AnnotationConfigApplicationContext(Config01.class)){
			
			Servicio1 scio = ctx.getBean("servicio1", Servicio1.class);
//			scio.servicio();
			scio.setMensaje("Primer Servicio");

			
			Servicio1 nuevo = ctx.getBean("servicio1", Servicio1.class);
			System.out.println(nuevo.getMensaje());
		}
		
	}
}
