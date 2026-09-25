package es.cursospring.mdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursospring.mdp.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
