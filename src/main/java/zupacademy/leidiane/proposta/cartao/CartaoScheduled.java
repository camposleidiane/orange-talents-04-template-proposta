package zupacademy.leidiane.proposta.cartao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import feign.FeignException;
import zupacademy.leidiane.proposta.proposta.Proposta;
import zupacademy.leidiane.proposta.proposta.PropostaRepository;

@Component
public class CartaoScheduled {
	
	@Autowired
	PropostaRepository propostaRepository;
	
	@Autowired
	CartaoClient cartaoClient;

	@Scheduled(fixedDelay = 60 * 1000)
	public void associaCartao() {
		
		Set<Proposta> propostasElegiveis = propostaRepository.propostasElegiveis();
		
		for (Proposta proposta : propostasElegiveis) {
			
			try {
				CartaoResponse cartao = cartaoClient.associaCartao(proposta.getId());
				Cartao cartaoCriado = cartao.toModel(proposta);
				proposta.setCartao(cartaoCriado);
				propostaRepository.save(proposta);
			} catch (FeignException e) {
				System.out.println("O cartão ainda não foi criado. Aguarde!");
			}		
		}		
	}
}
