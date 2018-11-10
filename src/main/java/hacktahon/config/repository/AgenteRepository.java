package hacktahon.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hacktahon.config.model.Agente;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long>{

}
