package zupacademy.leidiane.proposta.viagem;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import zupacademy.leidiane.proposta.cartao.Cartao;

public class ViagemRequest {
	
	@NotNull @NotBlank private String destino;
	@Future @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING) private LocalDate validoAte;
	
	@Deprecated
	public ViagemRequest() {
	}
	
	public ViagemRequest(@NotNull @NotBlank String destino, @Future LocalDate validoAte) {
		super();
		this.destino = destino;
		this.validoAte = validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getValidoAte() {
		return validoAte;
	}
	
	public Viagem toModel(Cartao cartao, String ipCliente, String userAgent) {
		return new Viagem(this.destino, this.validoAte, ipCliente, userAgent, cartao);
	}
}
