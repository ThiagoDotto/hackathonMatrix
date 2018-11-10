package hacktahon.config.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hacktahon.config.model.Ponto;
import hacktahon.config.repository.PontoRepository;

@RestController
public class PontoController {

	@Autowired
	private PontoRepository pontos;
	
	@GetMapping("/map")
	public String ola() {
		
		Ponto ponto = new Ponto();
		
		ponto.setCoordX("-222.222");
		ponto.setCoordY("222.333");
		ponto.setSeguro(true);
		
		pontos.save(ponto);
		
		return "teste";
	}
}
