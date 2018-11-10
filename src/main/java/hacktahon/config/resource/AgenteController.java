package hacktahon.config.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hacktahon.config.model.Agente;
import hacktahon.config.model.Ponto;
import hacktahon.config.repository.AgenteRepository;

@RestController
public class AgenteController {

	@Autowired
	private AgenteRepository agentes;

	@GetMapping("/agente/buscar")
	public ResponseEntity<?> agentes() {
		List<Agente> findAll = agentes.findAll();
		return !findAll.isEmpty() ? ResponseEntity.ok(findAll) : ResponseEntity.notFound().build();
	}

	@GetMapping("/agente/gerar/")
	public void criarAgentes(@PathParam("latitude") Double latitude, @PathParam("longitude") Double longitude) {
		Agente agente = new Agente(new Ponto(25.774, -80.19));
		agentes.save(agente);
	}

}
