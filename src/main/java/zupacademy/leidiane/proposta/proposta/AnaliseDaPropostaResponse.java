package zupacademy.leidiane.proposta.proposta;

public class AnaliseDaPropostaResponse {

	private String documento;
	private String nome;
	private Long idProposta;
	private ResultadoSolicitacao resultadoSolicitacao;
	
	public String getDocumento() {
		return documento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Long getIdProposta() {
		return idProposta;
	}
	
	public ResultadoSolicitacao getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public Status status() {
		return resultadoSolicitacao.getStatus();
	}
}
