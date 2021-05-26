package zupacademy.leidiane.proposta.utils.criptografia;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import org.springframework.security.crypto.encrypt.Encryptors;

@Convert
public class CriptografaDados implements AttributeConverter<String, String> {
	
	public String convertToDatabaseColumn(String dado) {
		return Encryptors.text("${criptografia.secret}", "654321").encrypt(dado);
	}
	
	public String convertToEntityAttribute(String dado) {
		return Encryptors.text("${criptografia.secret}", "654321").decrypt(dado);
	}

}
