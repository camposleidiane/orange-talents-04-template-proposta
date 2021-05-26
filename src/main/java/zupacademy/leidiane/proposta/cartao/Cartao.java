package zupacademy.leidiane.proposta.cartao;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import zupacademy.leidiane.proposta.cartao.bloqueio.BloqueioCartao;
import zupacademy.leidiane.proposta.cartao.bloqueio.StatusCartao;
import zupacademy.leidiane.proposta.proposta.Proposta;
import zupacademy.leidiane.proposta.utils.criptografia.CriptografaDados;

@Entity
public class Cartao {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Convert(converter=CriptografaDados.class) private String numero;
	private String titular;
	private LocalDateTime dataEmissao;
	@OneToOne(mappedBy= "cartao") private Proposta proposta;
	@OneToOne (cascade = CascadeType.MERGE) private BloqueioCartao bloqueioCartao;
	@Enumerated (EnumType.STRING) private StatusCartao status = StatusCartao.ATIVO;
	
	@Deprecated
	Cartao() {
	}

	public Cartao(String numero, String titular, LocalDateTime dataEmissao, Proposta proposta) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.dataEmissao = dataEmissao;
		this.proposta = proposta;
	}
	
	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public Proposta getProposta() {
		return proposta;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEmail() {
		return proposta.getEmail();
	}

	public StatusCartao getStatus() {
		return status;
	}
	
	public void setBloqueio(BloqueioCartao bloqueioCartao) {
		this.bloqueioCartao = bloqueioCartao;
		this.status = StatusCartao.BLOQUEADO;
	}

	public boolean bloqueado() {
		return this.status.equals(StatusCartao.BLOQUEADO);
	}
}
