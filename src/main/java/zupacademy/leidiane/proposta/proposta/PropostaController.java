package zupacademy.leidiane.proposta.proposta;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class PropostaController {
	
	@Autowired PropostaRepository propostaRepository;
	
	public PropostaController (PropostaRepository propostaRepository) {
		this.propostaRepository = propostaRepository;
	}
	
	@PostMapping("/propostas")
	@Transactional
	public ResponseEntity<?> novaProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder builder) {
		
		Proposta novaProposta = request.toModel();
		propostaRepository.save(novaProposta);
		URI enderecoConsulta = builder.path("/propostas/{id}").build(novaProposta.getId());
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
}
