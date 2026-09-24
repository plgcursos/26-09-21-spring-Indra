package es.cursospring.jpa.tests;

import es.cursospring.jpa.domain.Cliente;
import es.cursospring.jpa.domain.Cuenta;
import es.cursospring.jpa.persistence.Emf;
import jakarta.persistence.EntityManager;

public class Test02 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.getEmf().createEntityManager();
		Cliente cli = em.find(Cliente.class, 29);
		
		System.out.println(cli);
		
//		cli.getCuentas().forEach(c -> System.out.println(c));
//		cli.getCuentas().forEach(System.out::println);
		
		for (Cuenta cue : cli.getCuentas()) {
			System.out.println(cue);
			cue.getTarjetas().forEach(System.out::println);
		}
		
		
		
		em.close();
	}
}
