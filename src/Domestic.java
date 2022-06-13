
public class Domestic extends Plane {
	
	//public String[][] domesticInv = {{"QC, Montreal", "BC, Victoria", "NVT, Iqaluit", "NS, Halifax"},{"9:00AM", "5:45PM", "8:30PM", "11:50AM"}};
	private double price;
	
	public Domestic(String time, String from, String destination, String flightType, String flightClass, double price) {
		super(time, from, destination, flightType, flightClass);
		this.price = price;
			
		}
	
	public Domestic(double price){
    
        this(time, from, destination, "Domestic", flightClass, price);
    }
	
	public String getDestination() {
		return destination;
	}
	
	public String get

}

