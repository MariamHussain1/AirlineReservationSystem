/**
 * 
 * @author Mariam Hussain & Shruthi Konduru
 * 
 * This program is a child class of Plane.java. It uses the constructor from the parent class and has an additional method for setting and getting the price
 *
 */
public class Business extends Plane {
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
	public Business(String time, String from, String destination, String flightType, String flightClass, int seats, int childSeats) {
		super(time, from, destination, flightType, flightClass);
		}
	
	/**
	 * This program shows the total price by taking in the adult and child passenger count
	 * @param adultSeats: int
	 * @param childSeats: int
	 * @return the total price (double)
	 */
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
