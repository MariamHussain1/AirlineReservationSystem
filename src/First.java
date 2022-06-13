
public class First extends Plane {
	
	private double price;
	public First(String time, String from, String destination, String flightType, String flightClass, double price) {
		super(time, from, destination, flightType, flightClass);
		this.price = price;
			
		}
	
	public First(double price){
    
        this(time, from, destination, flightType, "First", price);
    }
	
	public String getDestination() {
		return destination;
	}
	
	public void setPrice(double price) {
		if(flightType.equals("Domestic")) {
			price = 4200; 
			
		}
		
		else if(fligh)
	}
	
	

}
