package hacktahon.config.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hacktahon.config.model.Agente;
import hacktahon.config.model.Ponto;
import hacktahon.config.model.Telefone;
import hacktahon.config.repository.AgenteRepository;
import hacktahon.config.repository.PontoRepository;
import hacktahon.config.service.CalcularQuadrante;

@CrossOrigin("*")
@RestController
public class AgenteController {

	@Autowired
	private AgenteRepository agentes;
	
	@Autowired
	private CalcularQuadrante servico;


	@GetMapping("/agent/buscar")
	public ResponseEntity<?> agentes() {
		List<Agente> findAll = agentes.findAll();
		return  ResponseEntity.ok(findAll);
	}

	@GetMapping("/agent/gerar")
	public void criarAgentes(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) {
		Agente agente = new Agente(new Ponto(latitude, longitude));
		agentes.save(agente);
	}
	
	@GetMapping("/agent/proximos")
	public ResponseEntity<?> buscarAgentesProximos(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) {

		List<Ponto> calculateBoundaries = servico.calculateBoundaries(latitude, longitude);
		List<Agente> findAll = agentes.findAllByPontoIn(calculateBoundaries);
		return  ResponseEntity.ok(findAll);
	}

}
