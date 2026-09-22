package es.cursospring.springcore;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursospring.springcore.config.Config04;
import es.cursospring.springcore.service.Servicio1;

public class App04 {
	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		try (var ctx = new AnnotationConfigApplicationContext(Config04.class)) {
			
			Servicio1 scio = ctx.getBean(Servicio1.class);
			scio.servicio();

			System.out.println("DataSource ok");
			System.out.println("Intro finalizar");
			tec.nextLine();
			
		}
		
	}
}
