
public class First extends Plane {
	
	private double price;
	private boolean under12 = false;
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
			if(under12 == true){
				price = 3600;
			}
		}
		
		else if(flightType.equals("International")){
			price = 5800;
			if(under12 == true){
				price = 5000;
			}
		}
	}
	
	public double getPrice(){
		return price;
	}
	
	

}
