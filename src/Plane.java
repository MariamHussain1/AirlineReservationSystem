

public abstract class Plane {
	
	private String from;
	private String destination;
	private String time;
	private String flightType;
	private String flightClass;
	
	public Plane(String time, String from, String destination, String flightType, String flightClass) {
		this.time = time;
		this.from = "CA, Toronto";
		this.destination = destination;
		this.flightType = flightType;
		this.flightClass = flightClass;
		
	}
	
	public void setClass(String flight){
		
		flightClass = flight;
	}
	
	public void setType(String type) {
		
		flightType = type;
	}
	
	public void setDestination(String d) {
		destination = d;
	}
	
	public abstract double getPrice();

}
