package zupacademy.leidiane.proposta.proposta;

public class PropostaResponse {
	
	private String documento;
	private String nome;
	private Status status;

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

	public Status getStatus() {
		return status;
	}
	
}

