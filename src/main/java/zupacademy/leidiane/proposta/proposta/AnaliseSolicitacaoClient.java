package zupacademy.leidiane.proposta.proposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="analise-solicitacao", url="http://localhost:9999")
public interface AnaliseSolicitacaoClient {

	@PostMapping("/api/solicitacao")
	AnaliseDaPropostaResponse consulta(AnaliseDePropostaRequest request);
}
