import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
/**
 * This class allows the user to choose between international and domestic flights. On either option being clicked they will be presented with 4 flight destination options which when one 
 * is clicked will lead them to the book tickets class.
 * @author Shruthi Konduru and Mariam Hussain
 * 
 */

public class ChooseFlights implements ActionListener{
	
	//creating arrays to store destinations for domestic and international flights
	public String [][] internationalInventory = { {"Paris", "Berlin", "Turkey", "Venice"} ,{"2:00AM", "7:00PM", "6:30AM", "4:00PM"}}; 
	public String[][] domesticInv = {{"Montreal", "Victoria", "Iqaluit", "Halifax"},{"9:00AM", "5:45PM", "8:30PM", "11:50AM"}};
	
	//adding the frame
	JFrame frame = new JFrame(); 
	
	//defining buttons
	JButton back = new JButton("BACK");  	
	JButton domestic = new JButton("Domestic");
	JButton international = new JButton("International");
	
	//defining image
	Icon pic = new ImageIcon("Images/chooseFlights.jpg");
	JLabel background = new JLabel(pic);
	
	//creating colors
	Color grey = new Color(211, 211, 211);
	Color pink = new Color(250, 181, 181);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
	//creating static variables that can be accessed in book tickets class
	public static String flightType; 
	public static String destination; 
	public static String time; 
	
	/**
	 * This method displays the objects defined on to the screen
	 * @throws MalformedURLException
	 */
	public ChooseFlights () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
	  
	    
	   
	     //adding the back button 
	    back.setBounds(50, 570, 150, 50);
	    back.setFocusable(false);
	    back.setFont(new Font("Times New Roman", Font.ITALIC, 30));
	    back.addActionListener(this);
	    back.setBackground(white);
	    
	    //adding international button
	    international.setBounds(200,325,200,125);
	    international.setFocusable(false);
	    international.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	    international.addActionListener(this);
	    international.setBackground(pink);
	    
	    //adding domestic button
	    domestic.setBounds(500,325,200,125);
	    domestic.setFocusable(false);
	    domestic.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	    domestic.addActionListener(this);
	    domestic.setBackground(pink);
	    
	  //setting bounds for the background image
	    background.setBounds(0,0,900,900);

		
	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
	    //adding components onto frame
		frame.add(back);
		frame.add(international);
		frame.add(domestic);
		frame.add(background);
		
		
			
	}
	
	/**
	 * This method uses ActionMouseListener to perform actions if a button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		
		//uses if statement to see if international button is clicked
		if(e.getSource() == international) {
			
			//sets flight type
			flightType = "International"; 
			
			//stores international destinations in an array and uses elements to display JOption Pane
			Object [] possibleValues = { "Paris, France 2:00AM", "Berlin, Germany 7:00PM", "Istanbul, Turkey 6:30AM", "Venice, Italy 4:00PM"};
			Object selectedValue = JOptionPane.showInputDialog(null,"You have chosen an International Flight, Choose your destination.", "Destination",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[3]);
			frame.dispose();
			
			//uses if statements to load different instances of book tickets class
	        if (selectedValue == possibleValues[0]) {
	        	//uses destination value from array to store in static variables declared earlier
				 destination = internationalInventory[0][0]; 
				 time = internationalInventory[1][0]; 
				try {
					//uses exception to load book tickets class with the static variables as parameters
					BookTickets booking = new BookTickets(destination, time);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
	        }
	        	
	        else if (selectedValue == possibleValues[1]) {
	        	//uses destination value from array to store in static variables declared earlier
	        	 destination = internationalInventory[0][1]; 
				 time = internationalInventory[1][1]; 
				try {
					//uses exception to load book tickets class with the static variables as parameters
					BookTickets booking = new BookTickets(destination, time);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
	        }	
	        else if (selectedValue == possibleValues[2]) { 
	        	//uses destination value from array to store in static variables declared earlier
	        	 destination = internationalInventory[0][2]; 
				 time = internationalInventory[1][2]; 
				try {
					//uses exception to load book tickets class with the static variables as parameters
					BookTickets booking = new BookTickets(destination, time);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
	        }	
	        
	        else if (selectedValue == possibleValues[3]) { 
	        	//uses destination value from array to store in static variables declared earlier
	        	 destination = internationalInventory[0][3]; 
				 time = internationalInventory[1][3]; 
				try {
					//uses exception to load book tickets class with the static variables as parameters
					BookTickets booking = new BookTickets(destination, time);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
	        }	
	        }
			
		if(e.getSource() == domestic) {
			//uses if statement: sets static variable to domestic
			flightType = "Domestic"; 
			
			//stores domestic flight destinations in array and outputs them in joption pane using array values
			Object [] possibleValues = { "Montreal 9AM", "Victoria 5:45 PM", "Iquluit 830PM", "Halifax 11:50AM"};
			Object selectedValue = JOptionPane.showInputDialog(null,"You have chosen a Domestic Flight, Choose your destination.", "Destination",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[3]);
			frame.dispose();
			
			//uses array element values to store values into static variables destination and time to pass on to book tickets class
			if (selectedValue == possibleValues[0]) {
				destination = domesticInv[0][0]; 
				time = domesticInv[1][0]; 
				try {
					//loads book tickets using try/catch with parameters
					BookTickets booking = new BookTickets(destination, time);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
			}
			
			//uses array element values to store values into static variables destination and time to pass on to book tickets class
			else if (selectedValue == possibleValues[1]) {
				 destination = domesticInv[0][1]; 
				 time = domesticInv[1][1]; 
				try {
					//loads book tickets using try/catch with parameters
					BookTickets booking = new BookTickets(destination, time);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
			}	
			
			//uses array element values to store values into static variables destination and time to pass on to book tickets class
			else if (selectedValue == possibleValues[2]) { 
				 destination = domesticInv[0][2]; 
				 time = domesticInv[1][2]; 
				try {
					//loads book tickets using try/catch with parameters
					BookTickets booking = new BookTickets(destination, time);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
			}
			
			//uses array element values to store values into static variables destination and time to pass on to book tickets class
			else if (selectedValue == possibleValues[3]) { 
				 destination = domesticInv[0][3]; 
				 time = domesticInv[1][3]; 
				try {
					//loads book tickets using try/catch with parameters
					BookTickets booking = new BookTickets(destination, time);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
			}
		}
		
		//last if statement: if back is pressed, welcome page is loaded
		if(e.getSource() == back) {
			try {
				Welcome wel2 = new Welcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			frame.dispose();
			
		}
		}
	}
