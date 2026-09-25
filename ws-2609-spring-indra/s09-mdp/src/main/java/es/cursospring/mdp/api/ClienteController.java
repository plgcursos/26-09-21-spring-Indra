package es.cursospring.mdp.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cursospring.mdp.domain.dto.ClienteDto;
import es.cursospring.mdp.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	private final ClienteService cliS;

	public ClienteController(ClienteService cliS) {
		this.cliS = cliS;
	}

	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll(){
		return ResponseEntity.ok(cliS.findAll());
	}
}
