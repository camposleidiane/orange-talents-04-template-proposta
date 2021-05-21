package zupacademy.leidiane.proposta.biometria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import zupacademy.leidiane.proposta.cartao.Cartao;

@Entity
public class Biometria {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	@NotNull String digital;
	@ManyToOne private Cartao cartao;
	
	@Deprecated
	public Biometria() {
	}
	
	public Biometria(String digital, Cartao cartao) {
		this.digital = digital;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getDigital() {
		return digital;
	}

	public Cartao getCartao() {
		return cartao;
	}
}
