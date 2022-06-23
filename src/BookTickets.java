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

public class BookTickets implements ActionListener{
	
	
	JFrame frame = new JFrame();  //adding the frame
	JPanel panel = new JPanel();
	JButton finalConfirm = new JButton("Confirm");
	JButton confirm = new JButton("Enter");
	JButton goBack = new JButton("Back");

	JLabel title = new JLabel();
	JLabel text = new JLabel();
	JLabel seatLabel = new JLabel();
	JButton eco = new JButton("Economy");
	JButton bus = new JButton("Business");
	JButton fir = new JButton("First Class");
	
	Color grey = new Color(211, 211, 211);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	public static String flightClass;
	public static String pass;
	public static String children;
	JLabel p = new JLabel("Adult Passengers");
	JLabel p2 = new JLabel("#Of Child Passengers (under 12)");
    JTextField passengers = new JTextField(30);
    JTextField child = new JTextField(30);
    boolean inputValid = false; 
    
    boolean selected = false; 
    int counter; 

	//JButton confirm2 = new JButton(); 
    
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
	String destinationChosen = ChooseFlights.destination; 
	String timeChosen = ChooseFlights.time; 
	String flightTypeChosen = ChooseFlights.flightType; 
	public BookTickets (String destination, String time) throws MalformedURLException{
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		
	    frame.getContentPane().setBackground(Color.white);
	    
	    //adding economy class button
	    frame.getContentPane().add(eco);
	    eco.setBounds(50, 200, 150, 100);
		eco.setFocusable(false);
		eco.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		eco.addActionListener(this);
		eco.setBackground(grayBlue); 
		eco.setBorder(border);

	    frame.pack();
	    
	    
	    //adding business class button
	    frame.getContentPane().add(bus);
	    bus.setBounds(50, 310, 150, 100);
		bus.setFocusable(false);
		bus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bus.addActionListener(this);
		bus.setBackground(Color.white); 
		bus.setBorder(border);

	    frame.pack();
	    
	    
	    //adding firstclass button
	    frame.getContentPane().add(fir);
	    fir.setBounds(50, 420, 150, 100);
	    fir.setFocusable(false);
	    fir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    fir.addActionListener(this);
	    fir.setBackground(grey); 
	    fir.setBorder(border);

	    frame.pack();
	    
	
	    //adding the back button 
	    finalConfirm.setBounds(300, 570, 150, 50);
	    finalConfirm.setFocusable(false);
	    finalConfirm.setFont(new Font("Times New Roman", Font.ITALIC, 30));
	    finalConfirm.addActionListener(this);
	    finalConfirm.setBackground(white);
	
		//add the title
		title.setText("Book Tickets");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(130,-230,650,650);
		title.setForeground(grayBlue);
		
		//add label
		text.setText("Choose Flight Class");
		text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		text.setBounds(50,-160,500,650);
		text.setForeground(Color.black);
		
		//add textfield
		p.setBounds(300, 150, 200, 30);
		p2.setBounds(300, 250, 200, 30);
		  
		passengers.setBounds(300, 200, 200, 30);  
		child.setBounds(300, 300, 200, 30); 
		
		confirm.setBounds(300, 350, 100, 50);
		confirm.setFocusable(false);
		confirm.addActionListener(this);
		confirm.setBackground(grayBlue);
		
	    goBack.setBounds(50, 570, 150, 50);
	    goBack.setFocusable(false);
	    goBack.setFont(new Font("Times New Roman", Font.ITALIC, 30));
	    goBack.addActionListener(this);
	    goBack.setBackground(white);
	    
	    seatLabel.setText("Choose Seats");
		seatLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		seatLabel.setBounds(550,70,200,200);
		seatLabel.setForeground(Color.black);
	    
		char l = 0;
	    int k = 0;
	    panel.setBounds(550,200,300,300);
	    panel.setLayout(new GridLayout(4,5,3,3));  
	      JToggleButton[][] seats = new JToggleButton[4][5];
	      for(int i = 0; i<4; i++) {
	    	  for(int j = 0; j<5; j++) {
	    		  k++;
	    		  seats[i][j] = new JToggleButton(l+""+k);
	    		  seats[i][j].addActionListener(new ActionListener() {
	    			  @Override
	    		      public void actionPerformed(ActionEvent e) {
		    				 counter++;
	    				  //JOptionPane.showMessageDialog(frame, ((JToggleButton)e.getSource()).isSelected());
	    		         }
	    		      });
	    		      panel.add(seats[i][j]);
	    		      frame.getContentPane().add(panel);    
	    		   }
	    		  }
			
	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	    
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
		

		
		
			
	}
	
	private boolean checkInt(String str) {
		boolean flag = true; 
		
		int strInt = Integer.parseInt(str); 
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(!(Character.isDigit(cur))|| strInt > 20) {
				
				flag = false;
			}
			

		}
		
		return flag;
		
			
		}
	
		
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == confirm)  {  
			//boolean inputValid = false; 
           pass = passengers.getText();  
           children = child.getText();  
           try {
           if (checkInt(pass)&&checkInt(children))  
           {  
        	   System.out.println("true");
        	   inputValid = true; 
        	   //frame.dispose();
               //try {
				//Welcome welcome = new Welcome();
			//} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			//} 
           } 
           else {
        	   JOptionPane.showMessageDialog(confirm, "Input is invalid");  
            	 passengers.setText("");  
              	 child.setText("");  
               }   
           }
           catch(Exception ee) {
        	   JOptionPane.showMessageDialog(confirm, "Input is invalid");  

           }
		}
		if(e.getSource() == bus) {
				
			flightClass = "Business";
			bus.setBackground(darkBlue);
			eco.setBackground(grayBlue);
			fir.setBackground(grey);
			System.out.println(flightClass);
			
			
			}
		if(e.getSource() == finalConfirm) {
			try {
			if ((flightClass.equals("Business")||flightClass.equals("First")||flightClass.equals("Economy")) && (inputValid) && (counter==((Integer.parseInt(children))+Integer.parseInt(pass)))) {
				
				System.out.println("Here");
				if (flightClass.equals("Business")) {
				Business plane = new Business(timeChosen, "CA, Toronto", destinationChosen, flightTypeChosen, flightClass, Integer.parseInt(pass), Integer.parseInt(children));
				LogIn.flightPoints += 200; 
				try(FileWriter file = new FileWriter("FlightHistory.txt", true);
					    BufferedWriter bw = new BufferedWriter(file);
					    PrintWriter out = new PrintWriter(bw))
					{
					//username password flighType flightClass destination departureTime  #adults #children seat#

					    out.println(LogIn.username + " "+LogIn.pswrd+" "+flightTypeChosen + " "+ flightClass+" " +destinationChosen + " "+timeChosen+" "+Integer.parseInt(pass)+" "+Integer.parseInt(children));
					    
					} 
				catch (IOException e12) {
					
				}
				
				}
			if (flightClass.equals("First")) {
				First plane = new First(timeChosen, "CA, Toronto", destinationChosen, flightTypeChosen, flightClass, Integer.parseInt(pass), Integer.parseInt(children));
				//LogIn.flightPoints += 200; 
				
				try(FileWriter file = new FileWriter("FlightHistory.txt", true);
					    BufferedWriter bw = new BufferedWriter(file);
					    PrintWriter out = new PrintWriter(bw))
					{
					//username password flighType flightClass destination departureTime  #adults #children seat#

					    out.println(LogIn.username + " "+LogIn.pswrd+" "+flightTypeChosen + " "+ flightClass+" " +destinationChosen + " "+timeChosen+" "+Integer.parseInt(pass)+" "+Integer.parseInt(children));
					    
					} 
				catch (IOException e12) {
					
				}
				
				if (LogIn.flightPoints >= 1000) {
					Object[]possibleValues = {"Check Flight History", "Book Another Flight", "Go Back to Main Menu"}; 
					Object selectedValue = JOptionPane.showInputDialog(null,"Your flight has been purchased through your lottery points.", "Confirmed Ticket Booking",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[2]);
			        if (selectedValue == possibleValues[0]) {
			        	Profile profile = new Profile(); 
			        }
			        if (selectedValue == possibleValues[1]) {
			        	ChooseFlights choose = new ChooseFlights(); 
			        }
			        if (selectedValue == possibleValues[2]) {
			        	Welcome newwel = new Welcome(); 
			        }



				}
				else {
					Object[]possibleValues = {"Check Flight History", "Book Another Flight", "Go Back to Main Menu"}; 
					Object selectedValue = JOptionPane.showInputDialog(null,"You have successfully booked your flight, you can choose to be redirected to the page of your choice.", "Confirmed Ticket Booking",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[2]);
			        if (selectedValue == possibleValues[0]) {
			        	Profile profile = new Profile(); 
			        }
			        if (selectedValue == possibleValues[1]) {
			        	ChooseFlights choose = new ChooseFlights(); 
			        }
			        if (selectedValue == possibleValues[2]) {
			        	Welcome newwel = new Welcome(); 
			        }


				}
				}
			if (flightClass.equals("Economy")) {
				Economy plane = new Economy(timeChosen, "CA, Toronto", destinationChosen, flightTypeChosen, flightClass, Integer.parseInt(pass), Integer.parseInt(children));
				LogIn.flightPoints += 200; 
				double price = plane.getPrice(Integer.parseInt(pass), Integer.parseInt(children));
				System.out.println(price);
				//LogIn.addPoints(200); 
				try(FileWriter file = new FileWriter("FlightHistory.txt", true);
					    BufferedWriter bw = new BufferedWriter(file);
					    PrintWriter out = new PrintWriter(bw))
					{
					//username password flighType flightClass destination departureTime  #adults #children seat#

					    out.println(LogIn.username + " "+LogIn.pswrd+" "+flightTypeChosen + " "+ flightClass+" " +destinationChosen + " "+timeChosen+" "+Integer.parseInt(pass)+" "+Integer.parseInt(children));
					    
					} 
	
				catch (IOException e12) {
					
				}
				}
				
			
			} 
			

			else {
				JOptionPane.showMessageDialog(finalConfirm, "Make sure to fill out all the information before confirming!");  
				counter = 0; 
			}
			}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(finalConfirm, "Make sure to fill out all the information before confirming!");  

			}
			
		}
			

		if(e.getSource() == goBack) {
			
			frame.dispose();
			try {
				Welcome newWel = new Welcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 			
			}
		
		
		
		
		if(e.getSource() == fir) {
			
			flightClass = "First";
			fir.setBackground(darkBlue);
			bus.setBackground(Color.white);
			eco.setBackground(grayBlue);
			System.out.println(flightClass);
			
	
		}
		if(e.getSource() == eco) {
		
			flightClass = "Economy";
			eco.setBackground(darkBlue);
			fir.setBackground(grey);
			bus.setBackground(Color.white);
			System.out.println(flightClass);

			
		}

		
		}
		}
	



		


		


		
		
