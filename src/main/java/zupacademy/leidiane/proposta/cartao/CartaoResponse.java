package zupacademy.leidiane.proposta.cartao;

import java.time.LocalDateTime;

import zupacademy.leidiane.proposta.proposta.Proposta;

public class CartaoResponse {
	private String id;
	private String titular;
	private LocalDateTime emitidoEm;
	
	public CartaoResponse(String id, String titular, LocalDateTime emitidoEm) {
		super();
		this.id = id;
		this.titular = titular;
		this.emitidoEm = emitidoEm;
	}

	public String getId() {
		return id;
	}

	public String getTitular() {
		return titular;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}
	
	public Cartao toModel(Proposta proposta) {
		return new Cartao(this.id, this.titular, this.emitidoEm, proposta);
	}

}

