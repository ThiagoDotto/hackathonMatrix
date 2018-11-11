package hacktahon.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hacktahon.config.model.Telefone;
import hacktahon.config.model.Ponto;
import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer>{
	
	public List<Telefone> findAllByPontoInAndStatus(List<Ponto> pontos,boolean flag);

}
