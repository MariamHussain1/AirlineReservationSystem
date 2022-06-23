public class First extends Plane {
	
	public double price;
	private double regPrice; 
	private double childPrice; 
	private int adultSeats;
	private int childSeats;
	public First(String time, String from, String destination, String flightType, String flightClass, int seats, int childSeats) {
		super(time, from, destination, flightType, flightClass);
		}
	
	
	
	public double getPrice(int adultSeats, int childSeats){	
		if(getFlightType().equals("Domestic")) {
			regPrice = 4200;
			childPrice = 3600;

		}
		else if(getFlightType().equals("International")){
			regPrice = 5800;
			childPrice = 5000;

		}
		return childSeats*childPrice + adultSeats*regPrice;
	}
	
	

}
