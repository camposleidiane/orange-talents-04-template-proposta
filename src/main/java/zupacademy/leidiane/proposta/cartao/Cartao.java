package zupacademy.leidiane.proposta.cartao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import zupacademy.leidiane.proposta.proposta.Proposta;

@Entity
public class Cartao {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String titular;
	private LocalDateTime dataEmissao;
	
	@OneToOne(mappedBy= "cartao")
	private Proposta proposta;
	
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

}
