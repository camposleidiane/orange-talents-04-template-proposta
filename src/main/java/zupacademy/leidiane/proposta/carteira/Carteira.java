package zupacademy.leidiane.proposta.carteira;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import zupacademy.leidiane.proposta.cartao.Cartao;

@Entity
public class Carteira {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@NotNull @NotBlank @Email private String email;
	@Enumerated (EnumType.STRING) TipoCarteira carteira;
	@ManyToOne private Cartao cartao;
	
	
	@Deprecated
	public Carteira() {
	}

	public Carteira(@NotNull @NotBlank @Email String email, TipoCarteira carteira, Cartao cartao) {
		super();
		this.email = email;
		this.carteira = carteira;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public TipoCarteira getCarteira() {
		return carteira;
	}

	public Cartao getCartao() {
		return cartao;
	}
}
