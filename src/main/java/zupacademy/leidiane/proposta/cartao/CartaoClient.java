package zupacademy.leidiane.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import zupacademy.leidiane.proposta.cartao.bloqueio.BloqueioCartaoRequest;
import zupacademy.leidiane.proposta.carteira.CarteiraRequest;
import zupacademy.leidiane.proposta.viagem.ViagemRequest;

@FeignClient(name="cartoes", url="${cartao.host}")
public interface CartaoClient {
	
	@GetMapping ("/api/cartoes")
	CartaoResponse associaCartao(@RequestParam(name="idProposta") Long idProposta);
	
	@PostMapping ("api/cartoes/{id}/bloqueios")
	void bloqueiaCartao(@PathVariable("id") String id, @RequestBody BloqueioCartaoRequest request);
	
	@PostMapping ("api/cartoes/{id}/avisos")
	void avisaViagem(@PathVariable("id") String id, @RequestBody ViagemRequest request);
	
	@PostMapping ("api/cartoes/{id}/carteiras")
	void adicionaCarteira(@PathVariable("id") String id, @RequestBody CarteiraRequest request);
}
	