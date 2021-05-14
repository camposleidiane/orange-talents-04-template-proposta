package zupacademy.leidiane.proposta.proposta;

public class AnaliseDePropostaRequest {
	
	private String documento;
	private String nome;
	private Long idProposta;
	
	/** @deprecated apenas para uso da framework **/
	
	public AnaliseDePropostaRequest() {
	}
	
	public AnaliseDePropostaRequest(String documento, String nome, Long idProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdProposta() {
		return idProposta;
	}

}
