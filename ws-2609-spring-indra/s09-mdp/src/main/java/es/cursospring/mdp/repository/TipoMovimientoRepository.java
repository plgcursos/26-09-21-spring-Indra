package es.cursospring.mdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursospring.mdp.domain.TipoMovimiento;

public interface TipoMovimientoRepository extends JpaRepository<TipoMovimiento, Integer> {

}
