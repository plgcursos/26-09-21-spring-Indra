package es.cursospring.jpa.tests;

import es.cursospring.jpa.domain.Movimiento;
import es.cursospring.jpa.persistence.Emf;
import jakarta.persistence.EntityManager;

public class Test03 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.getEmf().createEntityManager();

		Movimiento m = em.find(Movimiento.class, 1);
		
		System.out.println(m);
		
		
		em.close();
	}
}
