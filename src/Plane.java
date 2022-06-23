/**
 * 
 * @author Mariam Hussain & Shruthi Konduru
 * 
 * This is an abstract plane class which is the foundation for the other subclasses. It has static variables so they can be used in the book tickets class.
 * It has a constructor which creates an entry for a booked flight and sets and returns values for the passed parameters
 *
 */
public abstract class Plane {
	
	//declaration of static variables so they can be accessed in book tickets.java
	public static String from;
	public static String destination;
	public static String time;
	public static String flightType;
	public static String flightClass;
	public static final int seats = 20;
	
	/**
	 * This method is a constructor that takes in variables for a flight entry and instantiates them
	 * @param time: string that depicts time
	 * @param from: string 
	 * @param destination: string
	 * @param flightType: string
	 * @param flightClass: string
	 */
	public Plane(String time, String from, String destination, String flightType, String flightClass) {
		Plane.time = time;
		Plane.from = "CA, Toronto";
		Plane.destination = destination;
		Plane.flightType = flightType;
		Plane.flightClass = flightClass;
	
		
	}
	
	/**
	 * This method sets the flight type
	 * @param type: string to depict flight type (international/domestic)
	 */
	public void setFlightType(String type) {
		flightType = type;
	}
	
	/**
	 * This is a getter method that returns flightType
	 * @return flight type (international/domestic) based on what the user entered
	 */
	public String getFlightType() {
		return flightType;
	}
	
	/**
	 * This setter method sets the flight class (first/business/economy)
	 * @param fclass: String
	 */
	public void setFlightClass(String fclass) {
		flightClass = fclass;
	}
	
	/**
	 * This getter method returns the flight class
	 * @return flight class (first/business/economy)
	 */
	public String getflightClass() {
		return flightClass;
	}
	
	
	

}
