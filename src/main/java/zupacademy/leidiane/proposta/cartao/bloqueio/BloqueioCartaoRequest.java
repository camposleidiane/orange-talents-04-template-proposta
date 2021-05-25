package zupacademy.leidiane.proposta.cartao.bloqueio;

import javax.validation.constraints.NotBlank;

public class BloqueioCartaoRequest {

	@NotBlank private String sistemaResponsavel;
	
	@Deprecated
	public BloqueioCartaoRequest() {
	}

	public BloqueioCartaoRequest(@NotBlank String sistemaResponsavel) {
		super();
		this.sistemaResponsavel = sistemaResponsavel;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
}
