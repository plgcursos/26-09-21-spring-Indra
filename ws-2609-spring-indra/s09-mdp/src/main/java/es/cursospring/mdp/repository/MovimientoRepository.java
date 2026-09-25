package es.cursospring.mdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.cursospring.mdp.domain.Movimiento;
import es.cursospring.mdp.domain.dto.MovimientoDto;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

	// Proyeccion parcial
	@Query(
		"""
		select m.idMovimiento, m.tarjeta.idTarjeta, m.importe
		from Movimiento m
		""")
	List<Object[]> findAllParcial();
	

	// Dto Query
	@Query(
		"""
		select m.idMovimiento, m.tarjeta.idTarjeta, m.importe
		from Movimiento m
		""")
	List<MovimientoDto> findAllDto();
	
	
}
