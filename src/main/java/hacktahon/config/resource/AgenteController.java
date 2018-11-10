package hacktahon.config.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hacktahon.config.model.Agente;
import hacktahon.config.model.Ponto;
import hacktahon.config.repository.AgenteRepository;

@RestController
public class AgenteController {
	
	@Autowired
	private AgenteRepository agentes;
	
	@GetMapping("/")
	public String enemySpawn() {
		
		Ponto ponto = new Ponto();
		ponto.setCoordX("-220.121");
		ponto.setCoordY("220.111");
		ponto.setSeguro(true);
		
		Agente enemy = new Agente(ponto);
		agentes.save(enemy);
		
		return "teste";
	}

}
