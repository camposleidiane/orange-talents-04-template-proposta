package zupacademy.leidiane.proposta.proposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import zupacademy.leidiane.proposta.validacoes.CPForCNPJ;

@Entity
public class Proposta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@NotNull @NotBlank @CPForCNPJ private String documento;
	@NotNull @NotBlank @Email private String email;
	@NotNull @NotBlank private String nome;
	@NotNull @NotBlank private String endereco;
	@NotNull @Positive private BigDecimal salario;
	
	public Proposta () {
	}
	
	public Proposta(@NotNull @NotBlank @Email String email, @NotNull @NotBlank String nome,
			@NotNull @NotBlank String endereco, @NotNull @NotBlank @Positive BigDecimal salario,
			@NotNull String documento) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
	}
	
	public Long getId() {
		return id;
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
