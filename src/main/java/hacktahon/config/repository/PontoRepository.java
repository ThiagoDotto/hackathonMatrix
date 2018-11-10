package hacktahon.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hacktahon.config.model.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long>{

}
