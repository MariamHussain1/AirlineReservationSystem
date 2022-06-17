
public class Business extends Plane {
	
	public double price;
	public double childPrice;
	private int seats;
	private int childSeats;
	public Business(String time, String from, String destination, String flightType, String flightClass, int seats, int childSeats) {
		super(time, from, destination, flightType, flightClass);
			
		}
	
	
	public void setPrice(double price) {
		if(getFlightType().equals("Domestic")) {
			price = 2000;
		}
		else if(getFlightType().equals("International")){
			price = 3000;
		}
			
			
		}
	public void setPrice(double childPrice){
		if(getFlightType().equals("Domestic")) {
			childPrice = 1400;
		}
		else if(getFlightType().equals("International")){
			price = 2400;
		}
		
	}
	public double getPrice(){	
		return childSeats*childPrice + (seats-childSeats)*price;
	}
	
	

}
