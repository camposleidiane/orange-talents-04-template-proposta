package zupacademy.leidiane.proposta.viagem;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import zupacademy.leidiane.proposta.cartao.Cartao;

@Entity
public class Viagem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@NotNull @NotBlank private String destino;
	@NotNull @Future private LocalDate validoAte;
	@CreationTimestamp private LocalDateTime instanteAviso;
	private String ipCliente;
	private String userAgent;
	@ManyToOne private Cartao cartao;
	
	@Deprecated
	public Viagem() {
	}

	public Viagem(@NotNull @NotBlank String destino, @NotNull @Future LocalDate validoAte, String ipCliente,
			String userAgent, Cartao cartao) {
		super();
		this.destino = destino;
		this.validoAte = validoAte;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getValidoAte() {
		return validoAte;
	}

	public LocalDateTime getInstanteAviso() {
		return instanteAviso;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public Cartao getCartao() {
		return cartao;
	}	
}
