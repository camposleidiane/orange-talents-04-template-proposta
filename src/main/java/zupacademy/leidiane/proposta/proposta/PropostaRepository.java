package zupacademy.leidiane.proposta.proposta;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends CrudRepository<Proposta, Long> {
	
	Optional<Proposta> findByDocumento (String documento);
	
	Optional<Proposta> findById (Long id);
	
	Optional<Proposta> findByEmail(String email);
	
	@Query("SELECT p FROM Proposta p WHERE p.status = 'ELEGIVEL'" +
	        "AND p.cartao.id = NULL")
	Set<Proposta>propostasElegiveis();

}