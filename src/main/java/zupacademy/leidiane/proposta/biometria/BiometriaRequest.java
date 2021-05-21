package zupacademy.leidiane.proposta.biometria;

import java.util.Base64;

import javax.validation.constraints.NotBlank;

import zupacademy.leidiane.proposta.cartao.Cartao;

public class BiometriaRequest {
	
	@NotBlank private String digitalCodificada;
	
	public String getDigitalCodificada() {
		return digitalCodificada;
	}

	public Biometria toModel(Cartao cartao) {
		byte[] digitalDecode = Base64.getDecoder().decode(this.digitalCodificada.getBytes());
		String digitalDecodificada = new String(digitalDecode);
		return new Biometria(digitalDecodificada, cartao);
	}
}