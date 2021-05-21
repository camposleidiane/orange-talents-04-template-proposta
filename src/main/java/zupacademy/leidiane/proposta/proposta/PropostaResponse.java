package zupacademy.leidiane.proposta.proposta;

import zupacademy.leidiane.proposta.proposta.analise.StatusEnum;

public class PropostaResponse {
	
	private String documento;
	private String nome;
	private StatusEnum status;

	public PropostaResponse () {
	}
	
	public PropostaResponse (Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.status = proposta.getStatus();
	}

	public String getDocumento() {
		return documento;
	}
	
	public String getNome() {
		return nome;
	}

	public StatusEnum getStatus() {
		return status;
	}
	
}

