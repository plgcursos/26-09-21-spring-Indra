package es.cursospring.jpa.tests;

import es.cursospring.jpa.domain.TipoMovimiento;
import es.cursospring.jpa.persistence.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.getEmf().createEntityManager();
		
		TipoMovimiento tm = em.find(TipoMovimiento.class, 1);
		
		System.out.println(tm);
		
		
		em.close();
		
	}
}
