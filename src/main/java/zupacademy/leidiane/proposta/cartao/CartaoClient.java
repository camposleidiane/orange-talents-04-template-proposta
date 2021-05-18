package zupacademy.leidiane.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="cartoes", url="http://localhost:8888")
public interface CartaoClient {
	
	@GetMapping ("/api/cartoes")
	CartaoResponse associaCartao(@RequestParam(name="idProposta") Long idProposta);
}
