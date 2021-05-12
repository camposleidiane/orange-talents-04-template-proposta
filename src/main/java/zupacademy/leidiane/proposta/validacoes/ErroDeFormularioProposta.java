package zupacademy.leidiane.proposta.validacoes;

public class ErroDeFormularioProposta {
	private String campo;
	private String erro;
	
	public ErroDeFormularioProposta(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
