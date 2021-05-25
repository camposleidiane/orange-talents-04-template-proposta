package zupacademy.leidiane.proposta.cartao.bloqueio;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException;
import zupacademy.leidiane.proposta.cartao.Cartao;
import zupacademy.leidiane.proposta.cartao.CartaoClient;
import zupacademy.leidiane.proposta.cartao.CartaoRepository;

@RestController
@RequestMapping("/api/cartoes/{id}")
public class BloqueioCartaoController {
	
	@Autowired CartaoRepository cartaoRepository;
	@Autowired CartaoClient cartaoClient;
	
	@PostMapping("/bloqueio")
	public ResponseEntity<?> BloqueiaCartao(@PathVariable Long id, HttpServletRequest servletRequest, @AuthenticationPrincipal Jwt usuario) {
		
		String emailUsuario = (String) usuario.getClaims().get("email");
		
		Optional<Cartao> cartao = cartaoRepository.findById(id);
		
		if (!cartao.isPresent()) {
			return ResponseEntity.status(404).body("Este cartão não existe!");
		}
		
		if(!emailUsuario.equals(cartao.get().getEmail())) {
			return ResponseEntity.status(400).body("Você não tem autorização para bloquear este cartão!");
		}
		
		String userAgent = servletRequest.getHeader("User-Agent");
		String ip = servletRequest.getRemoteAddr();

		try {
			cartaoClient.bloqueiaCartao(cartao.get().getNumero(), new BloqueioCartaoRequest("proposta"));
			BloqueioCartao bloqueioCartao = new BloqueioCartao(ip, userAgent, cartao.get());
			cartao.get().setBloqueio(bloqueioCartao);
			cartaoRepository.save(cartao.get());
			return ResponseEntity.status(200).body("Cartão bloqueado com sucesso!");
		} catch (FeignException e){
			return ResponseEntity.status(400).body("Este cartão já foi bloqueado anteriormente!");
		}
	}
}
