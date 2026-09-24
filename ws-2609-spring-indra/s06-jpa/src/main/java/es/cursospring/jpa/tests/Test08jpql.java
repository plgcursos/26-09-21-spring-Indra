package es.cursospring.jpa.tests;

import es.cursospring.jpa.domain.dto.ClienteDto;
import es.cursospring.jpa.persistence.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Test08jpql {
	public static void main(String[] args) {
		
		EntityManager em = Emf.getEmf().createEntityManager();
		
		// Clientes pero solo los datos qel Dto
		String jpql = 
				"""
				select new es.cursospring.jpa.domain.dto.ClienteDto(
					c.idPersona, c.nombre, concat(c.apellido1, ' ', c.apellido2), c.nroCliente) 
					from Cliente c
					where c.idPersona < 30
				""";
		TypedQuery<ClienteDto> resu = em.createQuery(jpql, ClienteDto.class);
		resu.getResultList().forEach(System.out::println);
		
		em.close();
	}
}
