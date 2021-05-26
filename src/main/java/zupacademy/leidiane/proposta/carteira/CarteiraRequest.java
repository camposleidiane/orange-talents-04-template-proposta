package zupacademy.leidiane.proposta.carteira;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import zupacademy.leidiane.proposta.cartao.Cartao;

public class CarteiraRequest {
	
	@NotNull @NotBlank @Email private String email;
	private TipoCarteira carteira;
	
	public CarteiraRequest(@NotNull @NotBlank @Email String email, TipoCarteira carteira) {
		super();
		this.email = email;
		this.carteira = carteira;
	}

	public String getEmail() {
		return email;
	}

	public TipoCarteira getCarteira() {
		return carteira;
	}

	public Carteira toModel(Cartao cartao) {
		return new Carteira(this.email, this.carteira, cartao);
	}
	
}
