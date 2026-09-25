package es.cursospring.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursospring.springdata.domain.TipoMovimiento;

public interface TipoMovimientoRepository extends JpaRepository<TipoMovimiento, Integer> {

}
