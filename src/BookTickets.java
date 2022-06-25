import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import javax.swing.BorderFactory;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
/**
 * This class shows the page where the user can choose the flight class they want, and input the number of child and adult passengers and there after choose their flight and pay for tickets. It is linked to the plane classes and the lottery class where the user can use their win to get a free flight. From here the user can go back, or view their flight history
 * @author Shurthi Konduru & Mariam Hussain
 * 
 
 */

public class BookTickets implements ActionListener{
	
	//adding frame
	JFrame frame = new JFrame(); 
	
	//creating jpanel
	JPanel panel = new JPanel();
	
	//creating buttons
	JButton finalConfirm = new JButton("Confirm");
	JButton confirm = new JButton("Enter");
	JButton goBack = new JButton("Back");
	JButton eco = new JButton("Economy");
	JButton bus = new JButton("Business");
	JButton fir = new JButton("First");

	//creating labels
	JLabel title = new JLabel();
	JLabel text = new JLabel();
	JLabel seatLabel = new JLabel();
	JLabel p = new JLabel("Adult Passengers");
	JLabel p2 = new JLabel("#Of Child Passengers (under 12)");
	JLabel instructions = new JLabel("*Make sure to enter the #of passengers before clicking enter.");

	//creating colors
	Color grey = new Color(211, 211, 211);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	//static variables
	public static String flightClass;
	public static String pass;
	public static String children;
	public static String price;
	
	//creating text fields
    JTextField passengers = new JTextField(30);
    JTextField child = new JTextField(30);
   
    boolean inputValid = false; 
    boolean selected = false; 
    int counter; 
    String destinationChosen = ChooseFlights.destination; 
	String timeChosen = ChooseFlights.time; 
	String flightTypeChosen = ChooseFlights.flightType; 

    
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
	/**
	 * This method displays buttons allowing the user to choose between first/economy/business, two text fields to enter the number of passengers and an array of seats to choose from 
	 * and thereafter the user can book their tickets
	 * 
	 * @param destination: uses the static string variable from chooseflights.java
	 * @param time: uses the static string variable from chooseflights.java
	 * @throws MalformedURLException
	 */
	
	public BookTickets (String destination, String time) throws MalformedURLException{
		
		//setting properties for the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);

		//adding the title
		title.setText("Book Tickets");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(130,-230,650,650);
		title.setForeground(grayBlue);
		
		//adding choose flight class label
		text.setText("Choose Flight Class");
		text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		text.setBounds(50,-160,500,650);
		text.setForeground(Color.black);
	    
	    //adding economy class button
	    eco.setBounds(50, 200, 150, 100);
		eco.setFocusable(false);
		eco.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		eco.addActionListener(this);
		eco.setBackground(grayBlue); 
		eco.setBorder(border);
	    frame.pack();
	    
	    
	    //adding business class button
	    bus.setBounds(50, 310, 150, 100);
		bus.setFocusable(false);
		bus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bus.addActionListener(this);
		bus.setBackground(Color.white); 
		bus.setBorder(border);
	    frame.pack();
	    
	    
	    //adding first class button
	    fir.setBounds(50, 420, 150, 100);
	    fir.setFocusable(false);
	    fir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    fir.addActionListener(this);
	    fir.setBackground(grey); 
	    fir.setBorder(border);
	    frame.pack();

	    //setting bounds for the text fields
	    passengers.setBounds(300, 200, 200, 30);  
	    child.setBounds(300, 300, 200, 30); 

	    //setting bounds for labels for the text fields
	    p.setBounds(300, 150, 200, 30);
	    p2.setBounds(300, 250, 200, 30);
	    
	    //adding the instructions label
		instructions.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		instructions.setBounds(300,300,500,80);
		instructions.setForeground(Color.black);

	    //adding confirm button
	    confirm.setBounds(300, 350, 100, 50);
	    confirm.setFocusable(false);
	    confirm.addActionListener(this);
	    confirm.setBackground(grayBlue);
	  
	    //adding the back button
	    goBack.setBounds(50, 570, 150, 50);
	    goBack.setFocusable(false);
	    goBack.setFont(new Font("Times New Roman", Font.ITALIC, 30));
	    goBack.addActionListener(this);
	    goBack.setBackground(white);
	    
	    //adding a choose seats label
	    seatLabel.setText("Choose Seats");
		seatLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		seatLabel.setBounds(550,70,200,200);
		seatLabel.setForeground(Color.black);
		
		//adding the final confirm button (once all conditions are met)
	    finalConfirm.setBounds(700, 570, 150, 50);
	    finalConfirm.setFocusable(false);
	    finalConfirm.setFont(new Font("Times New Roman", Font.ITALIC, 30));
	    finalConfirm.addActionListener(this);
	    finalConfirm.setBackground(white);
	    
	    
	    char l = 0;
	    int k = 0;

	    //creating a panel with a grid layout to display the seats of the plane
	    panel.setBounds(550,200,300,300);
	    panel.setLayout(new GridLayout(4,5,3,3));

	    //creating an array of toggle buttons to have a plane of 20 seats
	    JToggleButton[][] seats = new JToggleButton[4][5];

	    //using a nested for loop to display the seats in a rows and to number each seat
	    for(int i = 0; i<4; i++) {
	    	for(int j = 0; j<5; j++) {
	    		k++;
	    		seats[i][j] = new JToggleButton(l+""+k);

	    		//implementing an ActionMouseListener for every toggle button
	    		seats[i][j].addActionListener(new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	    				//if the toggle button is pressed the counter (for seats) will increment
	    				counter++;
	    			}
	    		});

	    		//adding components to the screen
	    		panel.add(seats[i][j]);
	    		frame.getContentPane().add(panel);    
	    	}
	    }

	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	    
	    //adding components to screen
	    frame.add(seatLabel);
	    frame.add(text);
		frame.add(title);
		frame.add(eco);
		frame.add(bus);
		frame.add(fir);
		frame.add(p);
		frame.add(passengers); 
		frame.add(p2);
		frame.add(child);
		frame.add(confirm);
		frame.add(finalConfirm); 
		frame.add(goBack);
		frame.add(panel);
		frame.add(instructions);
		

		
		
			
	}
	
	/**
	 * This method checks the string to make sure it contains only digits
	 * @param str: the value entered in the passenger count textfield
	 * @return true or false
	 */
	private boolean checkInt(String str) {
		boolean flag = true; 
		
		//parses the string to int and uses for loop to make sure every char is a digit
		int strInt = Integer.parseInt(str); 
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			
			//validates the string (int) is less than 20 (total number of seats) and is an integer
			if(!(Character.isDigit(cur))|| strInt > 20) {
				
				flag = false;
			}
		}
		
		return flag;
			
		}
	
		
	
	/**
	 * This method uses ActionMouseListener to load instances based on what buttons are clicked
	 */
	public void actionPerformed(ActionEvent e) {
		
		//this confirm is to confirm the numbers of adult and child passengers
		if (e.getSource() == confirm)  {  
			
			//stores the input into variables
           pass = passengers.getText();  
           children = child.getText(); 
           
           try {
        	   
        //uses an if statement to validate the strings entered in text field
           if (checkInt(pass)&&checkInt(children))  
           {  
        	   inputValid = true; 
        
           } 
           else {
        	   
        	   //if input is not valid, the user will re-enter info
        	   JOptionPane.showMessageDialog(confirm, "Input is invalid");  
            	 passengers.setText("");  
              	 child.setText("");  
               }   
           }
           catch(Exception ee) {
        	   //show error message
        	   JOptionPane.showMessageDialog(confirm, "Input is invalid"); 
        	   passengers.setText("");  
               child.setText("");  

           }
		}
		
		//if the business class button is clicked static variable is set and button
		//changes color to show user it's been clicked
		if(e.getSource() == bus) {
				
			flightClass = "Business";
			bus.setBackground(darkBlue);
			eco.setBackground(grayBlue);
			fir.setBackground(grey);
		
			}
		
		//final confirm is clicked once the user has filled out all the information that has been validated in if statement
		if(e.getSource() == finalConfirm) {
			
			//uses try/catch statement to find errors
			try {
			if ((flightClass.equals("Business")||flightClass.equals("First")||flightClass.equals("Economy")) && (inputValid) && (counter==((Integer.parseInt(children))+Integer.parseInt(pass)))) {
				
				//creates instance for business class by setting the variables and calling business class
				if (flightClass.equals("Business")) {
				Business plane = new Business(timeChosen, "CA, Toronto", destinationChosen, flightTypeChosen, flightClass, Integer.parseInt(pass), Integer.parseInt(children));
				price = "$"+plane.getPrice(Integer.valueOf(pass), Integer.valueOf(children));
				
				//writes the flight entry into the flight history.txt
				try(FileWriter file = new FileWriter("FlightHistory.txt", true);
					    BufferedWriter bw = new BufferedWriter(file);
					    PrintWriter out = new PrintWriter(bw))
					{
					

					    out.println(LogIn.username + " "+LogIn.pswrd+" "+flightTypeChosen + " "+ flightClass+" " +destinationChosen + " "+timeChosen+" "+Integer.parseInt(pass)+" "+Integer.parseInt(children)+" "+price);
					    
					} 
				catch (IOException e12) {
					
				}
				
				//if points won from lottery.txt are sufficient
				if (LogIn.flightPoints >= 1000) {
					
					//options are stored in an array
					Object[]possibleValues = {"Check Flight History", "Book Another Flight", "Go Back to Main Menu"}; 
					Object selectedValue = JOptionPane.showInputDialog(null,"Your flight has been purchased through your lottery points.", "Confirmed Ticket Booking",JOptionPane.DEFAULT_OPTION, null,possibleValues, possibleValues[2]);
					
					//reset flightpoints to zero after they've been used to get a free flight
					LogIn.flightPoints = 0; 
					
					//based on option clicked a new screen is loaded
					if (selectedValue == possibleValues[0]) {
			        	frame.dispose(); 
			        	Profile profile = new Profile(); 
			        }
			        if (selectedValue == possibleValues[1]) {
			        	frame.dispose(); 

			        	ChooseFlights choose = new ChooseFlights(); 
			        }
			        if (selectedValue == possibleValues[2]) {
			        	frame.dispose(); 

			        	Welcome newwel = new Welcome(); 
			        }



				}
				
				//if points from lottery.txt aren't sufficient the same method applies except the user pays money
				else {
					//options are stored in an array
					Object[]possibleValues = {"Check Profile", "Book Another Flight", "Go Back to Main Menu"}; 
					double price = plane.getPrice(Integer.parseInt(pass), Integer.parseInt(children)); 
					Object selectedValue = JOptionPane.showInputDialog(null,"$"+price+"0 has been paid. You have successfully booked your flight, you can cancel your purchase by following the intructions in the profile page", "Confirmed Ticket Booking",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[2]);
			        
					//based on option clicked a new screen is loaded
					
					if (selectedValue == possibleValues[0]) {
			        	frame.dispose(); 

			        	Profile profile = new Profile(); 
			        }
			        if (selectedValue == possibleValues[1]) {
			        	frame.dispose(); 

			        	ChooseFlights choose = new ChooseFlights(); 
			        }
			        if (selectedValue == possibleValues[2]) {
			        	frame.dispose(); 

			        	Welcome newwel = new Welcome(); 
			        }


				}
				}
				
				//this is the same as the methods before except accounting for different cases
			if (flightClass.equals("First")) {
				
				//creates instance of first class
				First plane = new First(timeChosen, "CA, Toronto", destinationChosen, flightTypeChosen, flightClass, Integer.parseInt(pass), Integer.parseInt(children));
				price = "$"+plane.getPrice(Integer.valueOf(pass), Integer.valueOf(children));
				//writes the flight entry into the flight history.txt
				try(FileWriter file = new FileWriter("FlightHistory.txt", true);
					    BufferedWriter bw = new BufferedWriter(file);
					    PrintWriter out = new PrintWriter(bw))
					{

					    out.println(LogIn.username + " "+LogIn.pswrd+" "+flightTypeChosen + " "+ flightClass+" " +destinationChosen + " "+timeChosen+" "+Integer.parseInt(pass)+" "+Integer.parseInt(children)+" "+price);
					    
					} 
				catch (IOException e12) {
					
				}
				//if points won from lottery.txt are sufficient
				if (LogIn.flightPoints >= 1000) {
					//options are stored in an array
					Object[]possibleValues = {"Check Flight History", "Book Another Flight", "Go Back to Main Menu"}; 
					Object selectedValue = JOptionPane.showInputDialog(null,"Your flight has been purchased through your lottery points.", "Confirmed Ticket Booking",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[2]);
					//reset flightpoints to zero after they've been used to get a free flight
					LogIn.flightPoints = 0; 
					
					//based on option clicked a new screen is loaded
					if (selectedValue == possibleValues[0]) {
			        	frame.dispose(); 

			        	Profile profile = new Profile(); 
			        }
			        if (selectedValue == possibleValues[1]) {
			        	frame.dispose(); 

			        	ChooseFlights choose = new ChooseFlights(); 
			        }
			        if (selectedValue == possibleValues[2]) {
			        	frame.dispose(); 

			        	Welcome newwel = new Welcome(); 
			        }



				}
				else {
					//options are stored in an array
					Object[]possibleValues = {"Check Profile", "Book Another Flight", "Go Back to Main Menu"}; 
					double price = plane.getPrice(Integer.parseInt(pass), Integer.parseInt(children)); 
					Object selectedValue = JOptionPane.showInputDialog(null,"$"+price+"0 has been paid. You have successfully booked your flight, you can cancel your purchase by following the intructions in the profile page", "Confirmed Ticket Booking",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[2]);
			        
					//based on option clicked a new screen is loaded
					
					if (selectedValue == possibleValues[0]) {
			        	frame.dispose(); 

			        	Profile profile = new Profile(); 
			        }
			        if (selectedValue == possibleValues[1]) {
			        	frame.dispose(); 

			        	ChooseFlights choose = new ChooseFlights(); 
			        }
			        if (selectedValue == possibleValues[2]) {
			        	frame.dispose(); 

			        	Welcome newwel = new Welcome(); 
			        }


				}
				}
			if (flightClass.equals("Economy")) {
				
				//creates instance of economy class
				Economy plane = new Economy(timeChosen, "CA, Toronto", destinationChosen, flightTypeChosen, flightClass, Integer.parseInt(pass), Integer.parseInt(children));
			    price = "$"+plane.getPrice(Integer.valueOf(pass), Integer.valueOf(children));
				//writes the flight entry into the flight history.txt
				
				try(FileWriter file = new FileWriter("FlightHistory.txt", true);
					    BufferedWriter bw = new BufferedWriter(file);
					    PrintWriter out = new PrintWriter(bw))
					{

					    out.println(LogIn.username + " "+LogIn.pswrd+" "+flightTypeChosen + " "+ flightClass+" " +destinationChosen + " "+timeChosen+" "+Integer.parseInt(pass)+" "+Integer.parseInt(children)+" "+price);
					    
					} 
	
				catch (IOException e12) {
					
				}
				//if points won from lottery.txt are sufficient
				if (LogIn.flightPoints >= 1000) {
					//options are stored in an array
					Object[]possibleValues = {"Check Flight History", "Book Another Flight", "Go Back to Main Menu"}; 
					Object selectedValue = JOptionPane.showInputDialog(null,"Your flight has been purchased through your lottery points.", "Confirmed Ticket Booking",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[2]);
					//reset flightpoints to zero after they've been used to get a free flight
					LogIn.flightPoints = 0; 
					
					//based on option clicked a new screen is loaded
					if (selectedValue == possibleValues[0]) {
			        	frame.dispose(); 

			        	Profile profile = new Profile(); 
			        }
			        if (selectedValue == possibleValues[1]) {
			        	frame.dispose(); 

			        	ChooseFlights choose = new ChooseFlights(); 
			        }
			        if (selectedValue == possibleValues[2]) {
			        	frame.dispose(); 

			        	Welcome newwel = new Welcome(); 
			        }



				}
				else {
					//options are stored in an array
					Object[]possibleValues = {"Check Profile", "Book Another Flight", "Go Back to Main Menu"}; 
					double price = plane.getPrice(Integer.parseInt(pass), Integer.parseInt(children)); 
					Object selectedValue = JOptionPane.showInputDialog(null,"$"+price+"0 has been paid. You have successfully booked your flight, you can cancel your purchase by following the intructions in the profile page", "Confirmed Ticket Booking",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[2]);
			        
					//based on option clicked a new screen is loaded
					
					if (selectedValue == possibleValues[0]) {
			        	frame.dispose(); 

			        	Profile profile = new Profile(); 
			        }
			        if (selectedValue == possibleValues[1]) {
			        	frame.dispose(); 

			        	ChooseFlights choose = new ChooseFlights(); 
			        }
			        if (selectedValue == possibleValues[2]) {
			        	frame.dispose(); 

			        	Welcome newwel = new Welcome(); 
			        }


				}
				}
				
			
			} 
			

			else {
				
				//error message
				JOptionPane.showMessageDialog(finalConfirm, "Make sure to fill out all the information before confirming!");  
				counter = 0; 
				frame.dispose();
				BookTickets b = new BookTickets(ChooseFlights.destination, ChooseFlights.time);
			}
			}
			
			//error message
			catch(Exception ee) {
				JOptionPane.showMessageDialog(finalConfirm, "Make sure to fill out all the information before confirming!");  
				frame.dispose();
				try {
					BookTickets b = new BookTickets(ChooseFlights.destination, ChooseFlights.time);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			
		}
			
        //if back button is pressed welcome page is loaded
		if(e.getSource() == goBack) {
			
			frame.dispose();
			try {
				Welcome newWel = new Welcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 			
			}
		
		
		
		//if first class button is clicked it permanently becomes dark blue
		if(e.getSource() == fir) {
			
			flightClass = "First";
			fir.setBackground(darkBlue);
			bus.setBackground(Color.white);
			eco.setBackground(grayBlue);
			System.out.println(flightClass);
			
	
		}
		
		//if economy button is clicked, it permanently becomes dark blue
		if(e.getSource() == eco) {
		
			flightClass = "Economy";
			eco.setBackground(darkBlue);
			fir.setBackground(grey);
			bus.setBackground(Color.white);
			System.out.println(flightClass);

			
		}

		
		}
		}
	



		


		


		
	



		


		


		
