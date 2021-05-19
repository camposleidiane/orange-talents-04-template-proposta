package zupacademy.leidiane.proposta.validacoes;

import java.util.List;

public class ApiErrorResponse {
	
	private List<String> mensagens;
	
	
	public ApiErrorResponse(List<String> mensagens) {
		this.mensagens = mensagens;
	}

	public List<String> getMensagens() {
		return mensagens;
	}
}
