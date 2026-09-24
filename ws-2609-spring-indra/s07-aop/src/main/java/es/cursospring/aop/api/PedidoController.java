package es.cursospring.aop.api;

import java.util.List;

import org.aspectj.lang.annotation.Around;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cursospring.aop.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService pScio;

	public PedidoController(PedidoService pScio) {
		this.pScio = pScio;
	}
	
	@GetMapping
	public List<String> todos() {
		return pScio.consultarPedidos();
	}
	
	@PostMapping("/crear")   //     /pedidos/crear
	public String crear(@RequestParam String producto) {
		return pScio.crearPedido(producto);
	}
	
	@DeleteMapping("/cancelar/{id}")  //    /pedidos/cancelar/25
	public String cancelar(@PathVariable Integer id) {
		return pScio.cancelarPedido(id);
	}
	
}
