/**
 * 
 * @author Mariam Hussain & Shruthi Konduru
 * 
 * This program is a child class of Plane.java. It uses the constructor from the parent class and has an additional method for setting and getting the price
 *
 */
public class Economy extends Plane {
	//declaration of variables
	public double price;
	private double regPrice; 
	private double childPrice; 
	private int adultSeats;
	private int childSeats;
	
	/**
	 * This method is a constructor that takes in parameter and calls the constructor from the abstract plane class
	 * @param time: string
	 * @param from: string
	 * @param destination: string
	 * @param flightType: string
	 * @param flightClass: string
	 * @param seats: string
	 * @param childSeats: string
	 */
	public Economy(String time, String from, String destination, String flightType, String flightClass, int seats, int childSeats) {
		super(time, from, destination, flightType, flightClass);
		}
	
	

	/**
	 * This program shows the total price by taking in the adult and child passenger count
	 * @param adultSeats: int
	 * @param childSeats: int
	 * @return the total price (double)
	 */
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
