/**
 * 
 * @author Shruthi 
 *
 */
public abstract class International extends Plane {


//	public String [][] internationalInventory = { {"Paris", "Berlin", "Turkey", "Venice"} ,{"2:00AM", "7:00PM", "6:30AM", "4:00PM"}}; 
	private double price;
	
	public International(String time, String from, String destination, String flightType, String flightClass, double price) {
		super(time, from, destination, flightType, flightClass);
		this.price = price;
			
		}
	
	public International(double price){
    
        this(time, from, destination, "International", flightClass, price);
    }
	
	public String getDestination() {
		return destination;
	}
	


}
