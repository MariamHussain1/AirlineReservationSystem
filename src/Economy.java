/**
 * This program is a child class of Plane.java. It uses the constructor from the parent class and has an additional method for setting and getting the price
 * @author Mariam Hussain & Shruthi Konduru
 * 
 */
public class Economy extends Plane {
	//declaration of variables
	public int price;
	private int regPrice; 
	private int childPrice; 
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
	public int getPrice(int adultSeats, int childSeats){	
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
