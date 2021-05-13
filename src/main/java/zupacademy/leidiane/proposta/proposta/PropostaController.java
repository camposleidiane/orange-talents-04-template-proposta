package zupacademy.leidiane.proposta.proposta;

import java.net.URI;
import java.util.Optional;

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
		
		Optional<Proposta> propDocumento = propostaRepository.findByDocumento(novaProposta.getDocumento());
		
		if(propDocumento.isPresent()) {
			return ResponseEntity.status(422).body("Já existe uma proposta para esse solicitante!");
		}
		
		propostaRepository.save(novaProposta);
		URI enderecoConsulta = builder.path("/propostas/{id}").build(novaProposta.getId());
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
}
 