package hacktahon.config;

public class CheckPhoneSecurity {
	private double RANGE = 1000;
	private final double SECONDVALUE = 30.87;
	
	private double bigLat;
	private double smallLat;
	private double bigLng;
	private double smallLng;
	
	//Chamar essa função em loop para cada Telefone encontrado na área do usuário
	public void checkSecurity(Long phoneId, double phoneLat, double phoneLng) {
		calculateBoundaries(phoneLat, phoneLng);
		//if(buscaPorAgentesNosBoundaariesRetornarAlgumaCoisa)
			//set(phoneSecurity = false)
	}
	
	private void calculateBoundaries(double phoneLat, double phoneLng) {
		double rangeInDegrees;
		
		rangeInDegrees = RANGE / SECONDVALUE;
		rangeInDegrees = rangeInDegrees / 60;
		rangeInDegrees = rangeInDegrees / 60;
		
		bigLat = phoneLat + rangeInDegrees;
		smallLat = phoneLat - rangeInDegrees;
		bigLng = phoneLng + rangeInDegrees;
		smallLng = phoneLng - rangeInDegrees;
		
		if(bigLat > 90)
			bigLat = 90;
		if(smallLat < -90)
			smallLat = -90;
		if(bigLng > 180)
			bigLng = 180;
		if(smallLng < -180)
			smallLng = -180;
	}
}
