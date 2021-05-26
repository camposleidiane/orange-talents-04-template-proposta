package zupacademy.leidiane.proposta.viagem;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException;
import zupacademy.leidiane.proposta.cartao.Cartao;
import zupacademy.leidiane.proposta.cartao.CartaoClient;
import zupacademy.leidiane.proposta.cartao.CartaoRepository;

@RestController
@RequestMapping("/api/cartoes/{id}")
public class ViagemController {
	
	@Autowired CartaoRepository cartaoRepository;
	@Autowired ViagemRepository viagemRepository;
	@Autowired CartaoClient cartaoClient;
	
	@PostMapping("/avisos")
	public ResponseEntity<?> criaAvisoViagem (@RequestBody @Valid ViagemRequest request,
												@PathVariable("id") Long id,
												HttpServletRequest servletRequest) {
	
		String userAgent = servletRequest.getHeader("User-Agent");
		String ip = servletRequest.getRemoteAddr();
		Optional<Cartao> cartao = cartaoRepository.findById(id);
		
		if (!cartao.isPresent()) {
			return ResponseEntity.status(404).body
					("Não é possível cadastrar o aviso de viagem, pois este cartão não existe!");
		}
		
		try {
			cartaoClient.avisaViagem(cartao.get().getNumero(), request);
			Viagem viagem = request.toModel(cartao.get(), ip, userAgent);
			viagemRepository.save(viagem);
			return ResponseEntity.status(200).body
					("Aviso de viagem realizado com sucesso!");
		} catch (FeignException e){
			return ResponseEntity.status(400).body
					("Já existe um aviso de viagem para o destino informado!");
		}catch (Exception e) {
			return ResponseEntity.status(503).body
					("O serviço externo de cartões está temporariamente indisponível. Tente novamente mais tarde!");
		}
	}

}
