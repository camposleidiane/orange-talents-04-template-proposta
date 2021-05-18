package zupacademy.leidiane.proposta.cartao;

public class CartaoRequest {
	private String documento;
	private String nome;
	private Long idProposta;

	public CartaoRequest(String documento, String nome, Long idProposta) {
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
