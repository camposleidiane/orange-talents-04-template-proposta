package zupacademy.leidiane.proposta.proposta;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import feign.FeignException;

@RestController
@RequestMapping("/api")
public class PropostaController {
	
	@Autowired PropostaRepository propostaRepository;
	
	@Autowired AnaliseSolicitacaoClient analiseClient;
	
	@PostMapping("/propostas")
	public ResponseEntity<?> novaProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder builder) {
		
		Proposta novaProposta = request.toModel();
		
		Optional<Proposta> propDocumento = propostaRepository.findByDocumento(novaProposta.getDocumento());
		
		if(propDocumento.isPresent()) {
			return ResponseEntity.status(422).body("Já existe uma proposta para esse solicitante!");
		}
		
		propostaRepository.save(novaProposta);
		
		
		
		try {
			AnaliseDePropostaRequest analiseRequest = new AnaliseDePropostaRequest(novaProposta.getDocumento(),
																					novaProposta.getNome(),
																					novaProposta.getId());
			AnaliseDaPropostaResponse resultadoDaConsulta = analiseClient.consulta(analiseRequest);
			Status status = resultadoDaConsulta.status();
			novaProposta.setStatus(status);
			
		} catch (FeignException.UnprocessableEntity unprocessableEntity) {
			novaProposta.setStatus(Status.NAO_ELEGIVEL);
		} catch (FeignException.ServiceUnavailable ex) {
			propostaRepository.delete(novaProposta);
		}
		
		propostaRepository.save(novaProposta);
		
		URI enderecoConsulta = builder.path("/propostas/{id}").build(novaProposta.getId());
		return ResponseEntity.created(enderecoConsulta).build();
		
	}
	
	@GetMapping("/propostas/{id}")
	public ResponseEntity<?> acompanhaProposta(@PathVariable("id") Long id) {
		
		Optional <Proposta> propId = propostaRepository.findById(id);
		
		if(propId.isPresent()) {
			return ResponseEntity.ok(new PropostaResponse(propId.get()));
		}
		return ResponseEntity.status(404).body("Não existe solicitante com esse id!");
		
	}
}

 