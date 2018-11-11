package hacktahon.config.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hacktahon.config.model.Ponto;
import hacktahon.config.model.Telefone;
import hacktahon.config.repository.TelefoneRepository;
import hacktahon.config.service.CalcularQuadrante;

@CrossOrigin("*")
@RestController
public class TelefoneController {

	@Autowired
	private TelefoneRepository telefones;
	@Autowired
	private CalcularQuadrante servico;
	
	@PostMapping("/telefone/cadastrar")
	public ResponseEntity<?> novoTelefone(@RequestBody Telefone telefone) {
		if(telefone != null)
			return ResponseEntity.ok().body(telefones.save(telefone));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@GetMapping("/telefone/buscar")
	public ResponseEntity<?> buscarTodos() {
		List<Telefone> findAll = telefones.findAll();
		return ResponseEntity.ok(findAll);
	}
	
	
	@GetMapping("/telefone/proximos")
	public ResponseEntity<?> buscarTelefoneProximos(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) {

		List<Ponto> calculateBoundaries = servico.calculateBoundaries(latitude, longitude);
		List<Telefone> findAll = telefones.findAllByPontoInAndStatus(calculateBoundaries,true);
		return  ResponseEntity.ok(findAll);
	}
}
