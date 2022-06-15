
public class Economy extends Plane {
	
	private double price;
	private boolean under12 = false;
	public Economy(String time, String from, String destination, String flightType, String flightClass, double price) {
		super(time, from, destination, flightType, flightClass);
		this.price = price;
			
		}
	
	
	public void setPrice(double price) {
		if(getFlightType().equals("Domestic")) {
			price = 200;
			if(under12 == true){
				price = 100;
			}
		}
		
		else if(getFlightType().equals("International")){
			price = 1500;
			if(under12 == true){
				price = 1000;
			}
		}
	}
	
	public double getPrice(){
		return price;
	}
	
	

}
