


public abstract class Plane {
	
	public static String from;
	public static String destination;
	public static String time;
	public static String flightType;
	public static String flightClass;
	public static final int seats = 20;
	
	public Plane(String time, String from, String destination, String flightType, String flightClass) {
		Plane.time = time;
		Plane.from = "CA, Toronto";
		Plane.destination = destination;
		Plane.flightType = flightType;
		Plane.flightClass = flightClass;
	
		
	}
	
	public void setFlightType(String type) {
		flightType = type;
	}
	
	public String getFlightType() {
		return flightType;
	}
	
	public void setFlightClass(String fclass) {
		flightClass = fclass;
	}
	
	public String getflightClass() {
		return flightClass;
	}
	
	
	

}
