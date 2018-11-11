package hacktahon.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacktahon.config.model.Ponto;
import hacktahon.config.repository.PontoRepository;

@Service
public class CalcularQuadrante {

	@Autowired
	private PontoRepository pontos;

	private final double SECONDVALUE = 30.87;
	private final double RANGE = 5000;

	public List<Ponto> calculateBoundaries(double lat, double lng) {

		double rangeInDegrees;

		rangeInDegrees = RANGE / SECONDVALUE;
		rangeInDegrees = rangeInDegrees / 60;
		rangeInDegrees = rangeInDegrees / 60;

		Double bigLat = lat + rangeInDegrees;
		Double smallLat = lat - rangeInDegrees;
		Double bigLng = lng + rangeInDegrees;
		Double smallLng = lng - rangeInDegrees;

		if (bigLat > 90)
			bigLat = 90.0;
		if (smallLat < -90)
			smallLat = -90.0;

		if (bigLng > 180)
			bigLng = 180.0;
		if (smallLng < -180)
			smallLng = -180.0;

		List<Ponto> findByCoordXBetween = pontos.findByCoordXBetweenAndCoordYBetween(smallLat, bigLat, smallLng, bigLng);
		
		return findByCoordXBetween;
	}

}
