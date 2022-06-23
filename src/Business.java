public class Business extends Plane {
	
	public double price;
	private double regPrice; 
	private double childPrice; 
	private int adultSeats;
	private int childSeats;
	public Business(String time, String from, String destination, String flightType, String flightClass, int seats, int childSeats) {
		super(time, from, destination, flightType, flightClass);
		}
	
	
	public double getPrice(int adultSeats, int childSeats) {
		if(getFlightType().equals("Domestic")) {
			regPrice = 2000;
			childPrice = 1400;

					}
		else if(getFlightType().equals("International")){
			regPrice = 3000;
			childPrice = 2400;

		}
			

		return childSeats*childPrice + adultSeats*price;
	}
	
	

}
