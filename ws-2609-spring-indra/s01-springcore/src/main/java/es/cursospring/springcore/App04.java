package es.cursospring.springcore;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursospring.springcore.service.Servicio1;

public class App04 {
	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		try (var ctx = new ClassPathXmlApplicationContext("app04.xml")) {
			
			Servicio1 scio = ctx.getBean("servicio1", Servicio1.class);
			scio.servicio();

//			System.out.println("DataSource ok");
//			System.out.println("Intro finalizar");
//			tec.nextLine();
			
		}
		
	}
}
