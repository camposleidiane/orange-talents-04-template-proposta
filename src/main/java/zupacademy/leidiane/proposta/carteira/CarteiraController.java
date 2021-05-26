package zupacademy.leidiane.proposta.carteira;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import feign.FeignException;
import zupacademy.leidiane.proposta.cartao.Cartao;
import zupacademy.leidiane.proposta.cartao.CartaoClient;
import zupacademy.leidiane.proposta.cartao.CartaoRepository;

@RestController
@RequestMapping("/api/cartoes/{id}")
public class CarteiraController {
	@Autowired CartaoRepository cartaoRepository;
	@Autowired CarteiraRepository carteiraRepository;
	@Autowired CartaoClient cartaoClient;
	
	@PostMapping("/carteiras")
	public ResponseEntity<?> criaAvisoViagem (@RequestBody @Valid CarteiraRequest request,
												@PathVariable("id") Long id,
												UriComponentsBuilder uriBuilder) {
		
		Optional<Cartao> cartao = cartaoRepository.findById(id);
		
		if (!cartao.isPresent()) {
			return ResponseEntity.status(404).body
					("Não é possível associar uma carteira, pois este cartão não existe!");
		}
		
		Cartao cartaoEncontrado = cartao.get();
		
		if(carteiraRepository.findByCarteiraAndCartaoId(request.getCarteira(), id).isPresent()) {
			return ResponseEntity.status(422).body
					("Já existe uma carteira associada a este cartão!");
		}
		
		try {
			Carteira carteira = request.toModel(cartaoEncontrado);
			cartaoClient.adicionaCarteira(cartaoEncontrado.getNumero(), request);
			carteiraRepository.save(carteira);
			URI uri = uriBuilder.path("/carteiras/{id}").buildAndExpand(carteira.getId()).toUri();
			return ResponseEntity.created(uri).build();
		} catch (FeignException e) {
			return ResponseEntity.status(400).build();
		}
	}

}
