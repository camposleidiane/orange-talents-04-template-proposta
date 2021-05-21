package zupacademy.leidiane.proposta.proposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import zupacademy.leidiane.proposta.utils.validations.CPForCNPJ;

public class PropostaRequest {
	@NotNull @NotBlank @CPForCNPJ private String documento;
	@NotNull @NotBlank @Email private String email;
	@NotNull @NotBlank private String nome;
	@NotNull @NotBlank private String endereco;
	@NotNull @Positive private BigDecimal salario;
	
	public PropostaRequest(@NotNull @NotBlank String documento, @NotNull @NotBlank @Email String email,
			@NotNull @NotBlank String nome, @NotNull @NotBlank String endereco,
			@NotNull @Positive BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Proposta toModel() {
		return new Proposta(email, nome, endereco, salario, documento);
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
}
