package es.cursospring.springdata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.cursospring.springdata.domain.Cliente;
import es.cursospring.springdata.domain.Cuenta;
import es.cursospring.springdata.domain.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

	// Derived Query Method
	
	Optional<Tarjeta> findByPan(String pan);
	
	List<Tarjeta> findByMarca(String marca);
	List<Tarjeta> findByMarcaIgnoreCase(String marca);
	List<Tarjeta> findByMarcaContaining(String marca);
	List<Tarjeta> findByAnyoVencimientoBetween(int desde, int hasta);
	List<Tarjeta> findByCuenta(Cuenta id);
	
	// Declared Query Method
	
	@Query(
		"""
		select t
		from Tarjeta t
		join fetch t.cuenta c
		join fetch c.cliente cli
		where cli = ?1
		""")
	List<Tarjeta> findByCliente(Cliente c);
	
	@Query(
		"""
		select t
		from Tarjeta t
		join fetch t.cuenta c
		join fetch c.cliente cli
		where cli = :cli
		""")
	List<Tarjeta> findByCliente2(@Param("cli") Cliente c);
	
	//Tarjetas de clientes por Municipio
	@Query(value = 
			"""
			select *
			from tarjetas t
			join cuentas c on t.fk_cuenta = c.id_cuenta
			join clientes cli on c.fk_cliente = cli.id_cliente
			join personas p on cli.id_cliente = p.id_persona
			where p.municipio = ?1
			""", nativeQuery = true)
	List<Tarjeta> findByMunicipio(String municipio);
	
	//Sobrescribir un método generado por SpringData
	public default List<Tarjeta> findAll() {
		return findAll(Sort.by("anyoVencimiento"));
	}
}
