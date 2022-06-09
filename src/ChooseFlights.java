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
import javax.swing.JPanel;
import javax.swing.border.Border;
public class ChooseFlights implements ActionListener{
	public String [][] internationalInventory = { {"Paris", "Berlin", "Turkey", "Venice"} ,{"2:00AM", "7:00PM", "6:30AM", "4:00PM"}}; 

	JFrame frame = new JFrame();  //adding the frame
	JButton back = new JButton("BACK");  	
	JButton domestic = new JButton("Domestic");
	JButton international = new JButton("International");
	Icon pic = new ImageIcon("Images/chooseFlights.png");
	JLabel background = new JLabel(pic);
	
	Color grey = new Color(211, 211, 211);
	Color pink = new Color(250, 181, 181);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
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
	
		frame.add(back);
		frame.add(international);
		frame.add(domestic);
		frame.add(background);
		
		
			
	}
	
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == international) {
			Object [] possibleValues = { "Economy", "Business", "First Class"};
			Object selectedValue = JOptionPane.showInputDialog(null,"You have chosen an International Flight, Choose your flight type.", "Flight Type",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
	        
	        if (selectedValue == possibleValues[0]) {
	        	//frame.dispose();
	        	System.out.println("Economy class in a work in progress"); 
	        }
	        else if (selectedValue == possibleValues[1]) {
	        	System.out.println("Business class is a work in progress"); 
	        }	
	        else if (selectedValue == possibleValues[2]) {
	        	System.out.println("First class class is a work in progress"); 

	        }
			
			}
		if(e.getSource() == domestic) {
			Object [] possibleValues = { "Economy", "Business", "First Class"};
			Object selectedValue = JOptionPane.showInputDialog(null,"You have chosen an International Flight, Choose your flight type.", "Flight Type",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
	        
	        if (selectedValue == possibleValues[0]) {
	        	//frame.dispose();
	        	System.out.println("Economy class is a work in progress"); 
	        }
	        else if (selectedValue == possibleValues[1]) {
	        	System.out.println("Business class is a work in progress"); 
	        }	
	        else if (selectedValue == possibleValues[2]) {
	        	System.out.println("First class is a work in progress"); 

	        
			} 
		
		frame.dispose();
		}
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


