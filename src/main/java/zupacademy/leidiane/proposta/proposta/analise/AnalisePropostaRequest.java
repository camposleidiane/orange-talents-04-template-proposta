package zupacademy.leidiane.proposta.proposta.analise;

public class AnalisePropostaRequest {
	
	private String documento;
	private String nome;
	private Long idProposta;
	
	/** @deprecated apenas para uso da framework **/
	
	public AnalisePropostaRequest() {
	}
	
	public AnalisePropostaRequest(String documento, String nome, Long idProposta) {
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
