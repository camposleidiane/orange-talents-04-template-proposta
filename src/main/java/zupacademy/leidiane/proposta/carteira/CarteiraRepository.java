package zupacademy.leidiane.proposta.carteira;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long>{
	Optional<Carteira> findByCarteiraAndCartaoId(TipoCarteira tipoCarteira, Long cartaoId);
}
