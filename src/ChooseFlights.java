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
import javax.swing.JPanel;
import javax.swing.border.Border;
public class ChooseFlights implements ActionListener{
	
	JFrame frame = new JFrame();  //adding the frame
	JButton back = new JButton("BACK");  	
	JButton domestic = new JButton("Domestic");
	JButton international = new JButton("International");
	Icon pic = new ImageIcon("Images/chooseFlights.jpg");
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
				frame.dispose();
				try {
					AboutUs aboutUs = new AboutUs();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			
			frame.dispose();
			}
		if(e.getSource() == back) {
			frame.dispose();
			try {
				Welcome welcome = new Welcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		frame.dispose();
		}
		}
	}

		


