package zupacademy.leidiane.proposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioPropostaOrangeTalentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPropostaOrangeTalentsApplication.class, args);
	}

}
