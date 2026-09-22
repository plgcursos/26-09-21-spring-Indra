package es.cursospring.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursospring.springcore.service.Servicio1;

public class App05 {
	public static void main(String[] args) {
		
		try (var ctx = new ClassPathXmlApplicationContext("app05.xml")) {
			
			Servicio1 scio = ctx.getBean("servicio1", Servicio1.class);
			scio.servicio();
		}
	}
}
