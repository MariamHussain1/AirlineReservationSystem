public class Economy extends Plane {
	
	public double price;
	private double regPrice; 
	private double childPrice; 
	private int adultSeats;
	private int childSeats;
	public Economy(String time, String from, String destination, String flightType, String flightClass, int seats, int childSeats) {
		super(time, from, destination, flightType, flightClass);
		}
	
	

	
	public double getPrice(int adultSeats, int childSeats){	
		if(getFlightType().equals("Domestic")) {
			regPrice = 200;
			childPrice = 100;
						
			
		}
		
		else if(getFlightType().equals("International")){
			regPrice = 1500;
			childPrice = 1000;		
		}
		//price = childSeats*childPrice + (seats-childSeats)*regPrice; 
		return (childSeats*childPrice) + (adultSeats*regPrice) ;

	}
	
	

}
