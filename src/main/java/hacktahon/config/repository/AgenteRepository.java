package hacktahon.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hacktahon.config.model.Agente;
import hacktahon.config.model.Ponto;
import hacktahon.config.model.Telefone;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long> {

	List<Agente> findAllByPontoIn(List<Ponto> calculateBoundaries);
	
}
