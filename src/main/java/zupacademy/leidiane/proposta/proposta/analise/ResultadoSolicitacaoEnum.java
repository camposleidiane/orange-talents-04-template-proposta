package zupacademy.leidiane.proposta.proposta.analise;

public enum ResultadoSolicitacaoEnum {
	
	COM_RESTRICAO(StatusEnum.NAO_ELEGIVEL),
	SEM_RESTRICAO(StatusEnum.ELEGIVEL);
	
	private StatusEnum status;
	
	ResultadoSolicitacaoEnum(StatusEnum status) {
		this.status = status;
	}

	public StatusEnum getStatus() {
		return status;
	}
}
