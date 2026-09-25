package es.cursospring.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursospring.springdata.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
