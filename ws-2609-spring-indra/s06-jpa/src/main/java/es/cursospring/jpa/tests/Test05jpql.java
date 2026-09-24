package es.cursospring.jpa.tests;

import java.util.List;

import es.cursospring.jpa.domain.Cliente;
import es.cursospring.jpa.persistence.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Test05jpql {
	public static void main(String[] args) {
		
		EntityManager em = Emf.getEmf().createEntityManager();
		
		String jpql = "select c from Cliente c";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		List<Cliente> resu = q.getResultList();
		
//		resu.forEach(System.out::println);
		System.out.println("---------------------");
		
		jpql = "select c.nombre from Cliente c where lower(c.nombre) like :nom";
		TypedQuery<String> q1 = em.createQuery(jpql, String.class);
		q1.setParameter("nom", "a%");
		List<String> resu1 = q1.getResultList();
		
//		resu1.forEach(System.out::println);
		System.out.println("---------------------");

		jpql = "select c.idPersona, c.nombre, c.apellido1 from Cliente c where c.idPersona < :id";
		TypedQuery<Object[]> q2 = em.createQuery(jpql, Object[].class);
		q2.setParameter("id", 20);
		List<Object[]> resu2 = q2.getResultList();
		
		resu2.forEach(o -> System.out.println(o[0] + ": " + o[1] + " " + o[2]));
		
		
		em.close();
	}
}
