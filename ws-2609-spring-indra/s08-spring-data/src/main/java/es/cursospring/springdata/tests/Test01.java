package es.cursospring.springdata.tests;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cursospring.springdata.domain.Cliente;
import es.cursospring.springdata.domain.Movimiento;
import es.cursospring.springdata.domain.TipoMovimiento;
import es.cursospring.springdata.domain.dto.MovimientoProjection;
import es.cursospring.springdata.repository.ClienteRepository;
import es.cursospring.springdata.repository.MovimientoRepository;
import es.cursospring.springdata.repository.TarjetaRepository;
import es.cursospring.springdata.repository.TipoMovimientoRepository;
import jakarta.annotation.PostConstruct;

@Component
public class Test01 {

	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private TipoMovimientoRepository tipoRepo;
	@Autowired
	private TarjetaRepository tjtaRepo;
	@Autowired
	private MovimientoRepository movRepo;
	
	@PostConstruct
	public void init() {
//		testCli();
//		testTipoMov();
//		testDeriveMethod();
//		testDeclaredMethod();
//		testNativeQuery();
		testProyecciones();
	}
	
	public void testCli() {
		System.out.println(cliRepo.findById(19));
		
		cliRepo.findAll().forEach(System.out::println);
	}
	
	public void testTipoMov() {
		tipoRepo.findAll().forEach(System.err::println);
//		tipoRepo.deleteById(6);
		tipoRepo.save(new TipoMovimiento("NUEVO"));
		System.out.println();
		tipoRepo.findAll().forEach(System.err::println);
	}
	
	public void testDeriveMethod() {
		tjtaRepo.findAll().forEach(System.err::println);
//		tjtaRepo.findByMarca("Mastercard").forEach(System.err::println);
//		System.err.println(tjtaRepo.findByPan("5619003052546690"));
//		tjtaRepo.findByMarcaContaining("Master").forEach(System.err::println);
//		tjtaRepo.findByMarcaIgnoreCase("mastercard").forEach(System.err::println);
//		tjtaRepo.findByAnyoVencimientoBetween(2030, 2032).forEach(System.err::println);
	}
	
	public void testDeclaredMethod() {
		Optional<Cliente> c = cliRepo.findById(19);
		if (c.isPresent())
			tjtaRepo.findByCliente(c.get()).forEach(System.err::println);
	}
	
	public void testNativeQuery() {
		tjtaRepo.findByMunicipio("Madrid").forEach(System.err::println);
	}
	
	public void testProyecciones() {
//		movRepo.findAllParcial()
//			.forEach(o -> System.err.println(Arrays.asList(o)));
//		movRepo.findAllConstructorDto()
//			.forEach(System.err::println);
//		movRepo.findAllDto()
//		.forEach(System.err::println);
		for (MovimientoProjection mov : movRepo.findAllProjection()) {
			System.err.println(
				mov.getIdMovimiento() + ", " + mov.getIdTarjeta() + ", " + mov.getImporte());
		}
	}
}
