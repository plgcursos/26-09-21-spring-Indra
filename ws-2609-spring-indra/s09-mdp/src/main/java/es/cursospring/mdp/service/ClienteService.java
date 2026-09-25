package es.cursospring.mdp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.cursospring.mdp.domain.Cliente;
import es.cursospring.mdp.domain.dto.ClienteDto;
import es.cursospring.mdp.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository cliRepo;

	public ClienteService(ClienteRepository cliRepo) {
		this.cliRepo = cliRepo;
	}

	public List<ClienteDto> findAll(){
//		List<Cliente> clientes = cliRepo.findAll();
//		List<ClienteDto> resp = new LinkedList<ClienteDto>();
//		for (Cliente cli : clientes) {
//			resp.add(toDto(cli));
//		}
//		return resp;
		return cliRepo
			.findAll()
			.stream()
			.map(this::toDto)
			.toList();
	}
	
	private ClienteDto toDto(Cliente c) {
		return new ClienteDto(c.getIdPersona(), c.getNombre(), c.getApellido1() + " " + c.getApellido2(), c.getNroCliente());
	}
}
