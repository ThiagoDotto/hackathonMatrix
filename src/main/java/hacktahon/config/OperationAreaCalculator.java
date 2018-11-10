package hacktahon.config;


// Ao ser criada deve receber Latitude, Longitude e Alcance de Busca em Metros.
// Sempre que atualizar a localização do usuário chamar calculateBoundaries()
public class OperationAreaCalculator {
	private double lat;
	private double lng;
	private double range;
	
	public double bigLat;
	public double smallLat;
	public double bigLng;
	public double smallLng;
	
	private double SECONDVALUE = 30.87;
	public OperationAreaCalculator(double Lat, double Lng, double range) {
		this.lat = Lat;
		this.lng = Lng;
		this.range = range;
		calculateBoundaries();
	}
	
	public void calculateBoundaries(){
		double rangeInDegrees;
		
		rangeInDegrees = range / SECONDVALUE;
		rangeInDegrees = rangeInDegrees / 60;
		rangeInDegrees = rangeInDegrees / 60;
		
		bigLat = lat + rangeInDegrees;
		smallLat = lat - rangeInDegrees;
		bigLng = lng + rangeInDegrees;
		smallLng = lng - rangeInDegrees;
		
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

