package es.cursospring.jpa.tests;

import es.cursospring.jpa.domain.Cuenta;
import es.cursospring.jpa.persistence.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Test07jpql {
	public static void main(String[] args) {
		
		EntityManager em = Emf.getEmf().createEntityManager();
		
		// Todas las cuentas que tengan alguna tarjeta Visa
//		String jpql = 
//				"""
//				select c from Cuenta c 
//				join c.tarjetas t 
//				where lower(t.marca) = :marca
//				order by c.nroCuenta
//				""";

		// Mismo resultado con una sola select
		String jpql = 
				"""
				select c from Cuenta c 
				join fetch c.tarjetas t 
				join fetch c.cliente
				where lower(t.marca) = :marca
				order by c.nroCuenta
				""";
		TypedQuery<Cuenta> q = em.createQuery(jpql, Cuenta.class);
		q.setParameter("marca", "visa");
		
		q.getResultList().forEach(System.out::println);
		
		em.close();
	}
}
