package zupacademy.leidiane.proposta.proposta.analise;

public class AnalisePropostaResponse {

	private String documento;
	private String nome;
	private Long idProposta;
	private ResultadoSolicitacaoEnum resultadoSolicitacao;

	public String getDocumento() {
		return documento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Long getIdProposta() {
		return idProposta;
	}
	
	public ResultadoSolicitacaoEnum getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public StatusEnum status() {
		return resultadoSolicitacao.getStatus();
	}
}
