/**
 * This program is a child class of Plane.java. It uses the constructor from the parent class and has an additional method for setting and getting the price
 * @author Mariam Hussain & Shruthi Konduru
 *
 */
public class First extends Plane {
	
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
	public First(String time, String from, String destination, String flightType, String flightClass, int seats, int childSeats) {
		super(time, from, destination, flightType, flightClass);
		}
	
	
	/**
	 * This program shows the total price by taking in the adult and child passenger count
	 * @param adultSeats: int
	 * @param childSeats: int
	 * @return the total price (double)
	 */
	public int getPrice(int adultSeats, int childSeats){
		
		//sets adult and child price if flight type equals domestic (uses parent class method)
		if(getFlightType().equals("Domestic")) {
			regPrice = 4200;
			childPrice = 3600;

		}
		//sets adult and child price if flight type equals international (uses parent class method)
		else if(getFlightType().equals("International")){
			regPrice = 5800;
			childPrice = 5000;

		}
		return childSeats*childPrice + adultSeats*regPrice;
	}
	
	

}
