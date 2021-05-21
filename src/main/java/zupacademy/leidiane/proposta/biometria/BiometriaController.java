package zupacademy.leidiane.proposta.biometria;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import zupacademy.leidiane.proposta.cartao.Cartao;
import zupacademy.leidiane.proposta.cartao.CartaoRepository;

@RestController
@RequestMapping("/api/cartoes/{id}")
public class BiometriaController {
	
	@Autowired CartaoRepository cartaoRepository;
	@Autowired BiometriaRepository biometriaRepository;
	
	@PostMapping("/biometrias")
	public ResponseEntity<?> salvaBiometria (@RequestBody @Valid BiometriaRequest request,
												@PathVariable("id") Long id,
												UriComponentsBuilder uriBuilder) {
		
		if (!Base64.isBase64(request.getDigitalCodificada())) {
			return ResponseEntity.status(400).body("Biometria não enviada ou inválida!");
		}
		
		Optional<Cartao> cartao = cartaoRepository.findById(id);
		
		if(cartao.isEmpty()) {
			return ResponseEntity.status(404).body("Cartão não encontrado!");
		}
		
		Biometria novaBiometria = request.toModel(cartao.get());
		biometriaRepository.save(novaBiometria);
		URI uri = uriBuilder.path("/biometrias/{id}").build(novaBiometria.getId());
		return ResponseEntity.created(uri).build();
	}
}
