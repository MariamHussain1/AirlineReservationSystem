
public class Business extends Plane {
	
	private double price;
	private boolean under12 = false;
	public Business(String time, String from, String destination, String flightType, String flightClass, double price) {
		super(time, from, destination, flightType, flightClass);
		this.price = price;
			
		}
	
	public Business(double price){
    
        this(time, from, destination, flightType, "Business", price);
    }
	
	public String getDestination() {
		return destination;
	}
	
	public void setPrice(double price) {
		if(flightType.equals("Domestic")) {
			price = 2000;
			if(under12 == true){
				price = 1400;
			}
		}
		
		else if(flightType.equals("International")){
			price = 3000;
			if(under12 == true){
				price = 2400;
			}
		}
	}
	
	public double getPrice(){
		return price;
	}
	
	

}
