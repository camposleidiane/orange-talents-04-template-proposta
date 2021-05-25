package zupacademy.leidiane.proposta.cartao.bloqueio;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import zupacademy.leidiane.proposta.cartao.Cartao;

@Entity
public class BloqueioCartao {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;
	@CreationTimestamp private LocalDateTime horaBloqueio;
	private String ipCliente;
	private String userAgent;
	@OneToOne(mappedBy="bloqueioCartao") private Cartao cartao;
	
	@Deprecated
	public BloqueioCartao() {
	}

	public BloqueioCartao(String ipCliente, String userAgent, Cartao cartao) {
		super();
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}
	public LocalDateTime getHoraBloqueio() {
		return horaBloqueio;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public String getUserAgent() {
		return userAgent;
	}

}
