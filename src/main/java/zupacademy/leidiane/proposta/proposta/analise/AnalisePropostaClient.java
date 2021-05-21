package zupacademy.leidiane.proposta.proposta.analise;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="analise-solicitacao", url="${analise.host}")
public interface AnalisePropostaClient {

	@PostMapping("/api/solicitacao")
	AnalisePropostaResponse consulta(AnalisePropostaRequest request);
}
