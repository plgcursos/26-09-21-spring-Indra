package es.cursospring.springdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.cursospring.springdata.domain.Movimiento;
import es.cursospring.springdata.domain.dto.MovimientoDto;
import es.cursospring.springdata.domain.dto.MovimientoProjection;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

	// Proyeccion parcial
	@Query(
		"""
		select m.idMovimiento, m.tarjeta.idTarjeta, m.importe
		from Movimiento m
		""")
	List<Object[]> findAllParcial();
	
	// Constructor expression (no usar, utilizar el proximo ejemplo)
	@Query(
		"""
		select new es.cursospring.springdata.domain.dto.MovimientoDto(m.idMovimiento, m.tarjeta.idTarjeta, m.importe)
		from Movimiento m
		""")
	List<MovimientoDto> findAllConstructorDto();
	
	// Dto Query
	@Query(
		"""
		select m.idMovimiento, m.tarjeta.idTarjeta, m.importe
		from Movimiento m
		""")
	List<MovimientoDto> findAllDto();
	
	// Proyeccion sobre Interface
	@Query(
		"""
		select m.idMovimiento as idMovimiento, m.tarjeta.idTarjeta as idTarjeta, m.importe as importe
		from Movimiento m
		""")
	List<MovimientoProjection> findAllProjection();
	
}
