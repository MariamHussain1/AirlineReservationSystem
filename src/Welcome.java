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
/**
 * 
 * @author Mariam Hussain and Shruthi Konduru
 * This class acts as the main menu for the program where the user can redirect themselves to where they'd like to go 
 */
public class Welcome implements ActionListener{
	
	
	//adding the frame
	JFrame frame = new JFrame();  
	//adding the back button 
	JButton back = new JButton("BACK");  
	//adding all of the JLabels to be displayed as text 
	JLabel title = new JLabel();
	JLabel text1 = new JLabel();
	JLabel text2 = new JLabel();
	JLabel text3 = new JLabel();
	JPanel greyPanel = new JPanel();
	JPanel secondGreyPanel = new JPanel();
	JLabel userDetails = new JLabel(); 
	
	//defining the buttons and images associated with each respective button 
	Icon pfp = new ImageIcon("Images/profile.png");
	JButton profile = new JButton(pfp);
	Icon flight = new ImageIcon("Images/flights.png");
	JButton bookFlight = new JButton(flight);
	Icon lottery = new ImageIcon("Images/lotto.png");
	JButton PlayLottery = new JButton(lottery);
	
	//creating colors
	Color grey = new Color(211, 211, 211);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	// creating a border for the buttons 
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
	/**
	 * This method defines and adds all the components to the frame 
	 * @throws MalformedURLException
	 */
	public Welcome () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		
	    frame.getContentPane().setBackground(Color.white);
	    
	    //setting bounds for the profile image
	    frame.getContentPane().add(profile);
	    profile.setBounds(130, 180, 200, 200);
		profile.setFocusable(false);
		profile.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		profile.addActionListener(this);
		profile.setBackground(darkBlue); 
		profile.setBorder(border);

	    frame.pack();
	    
	    frame.getContentPane().add(text1);
	    frame.pack();
	    
	    //adding the description for profile button 
	    text1.setText("View Profile");
		text1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text1.setBounds(140,300,200,200);
		text1.setForeground(darkBlue);
		
		//adding components to user details label 
		userDetails.setText("Username: "+LogIn.username+"    Password: "+LogIn.pswrd);
		userDetails.setFont(new Font("Times New Roman", Font.BOLD, 50));
		userDetails.setBounds(100,670,800,100);
		userDetails.setForeground(grayBlue);



	    
	    //setting bounds for the flight image
	    frame.getContentPane().add(bookFlight);
	    bookFlight.setBounds(355, 180, 200, 200);
		bookFlight.setFocusable(false);
		bookFlight.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		bookFlight.addActionListener(this);
		bookFlight.setBackground(Color.white); 
		bookFlight.setBorder(border);

	    frame.pack();
	    
	    
	    //adding caption for the book flight image
	    frame.getContentPane().add(text2);
	    text2.setText("Book a flight");
		text2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text2.setBounds(365,300,200,200);
		text2.setForeground(darkBlue);
	    
	    //setting bounds for the lottery image
	    frame.getContentPane().add(PlayLottery);
	    PlayLottery.setBounds(580, 180, 200, 200);
	    PlayLottery.setFocusable(false);
	    PlayLottery.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	    PlayLottery.addActionListener(this);
	    PlayLottery.setBackground(grey); 
	    PlayLottery.setBorder(border);

	    frame.pack();
	    
	    //adding caption under the lottery button
	    frame.getContentPane().add(text3);
	    text3.setText("Play Lottery");
		text3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text3.setBounds(590,300,200,200);
		text3.setForeground(darkBlue);
	    
		
	    //adding the back button 
	    back.setBounds(50, 570, 150, 50);
	    back.setFocusable(false);
	    back.setFont(new Font("Times New Roman", Font.ITALIC, 30));
	    back.addActionListener(this);
	    back.setBackground(white);
	
		//add the title
		title.setText("Welcome, "+LogIn.username);
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(190,-230,650,650);
		title.setForeground(grayBlue);
		
		
		 // Add grey panels to the top and bottom of the page
		 
		greyPanel.setBackground(grey);
	    greyPanel.setBounds(0,0,900,100);
	    secondGreyPanel.setBackground(grey);
	    secondGreyPanel.setBounds(0,550,900,100);
			
	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
	    // adding all components to frame 
		frame.add(back);
		frame.add(title);
		frame.add(userDetails); 
		frame.add(greyPanel);
		frame.add(secondGreyPanel);
		frame.add(profile);
		frame.add(bookFlight);
		frame.add(PlayLottery);
		frame.add(text1);
		frame.add(text2);
		frame.add(text3);
		
		
			
	}
	/**
	 * Thsi method uses ActionMouseListener to perform actions based on what button gets clicked 
	 */
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == profile) {
				frame.dispose();
				try {
					// if profile is clicked, the profile class is called 
					Profile profil = new Profile();
				} catch (MalformedURLException e1) {					
					e1.printStackTrace();
				} 
			
			frame.dispose();
			}
		if(e.getSource() == bookFlight) {
			frame.dispose();
			try {
				// if chooseflights is clicked, the chooseflights class is called 
				ChooseFlights choose = new ChooseFlights();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} 
		
		frame.dispose();
		}
		
		if (e.getSource()==PlayLottery) {
			try {
				//if lottery is clicked, the lottery class is called 
				Lottery lotto = new Lottery ();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} 
		}
		if(e.getSource() == back) {
			frame.dispose();
			try {
				// if back is clicked, the user is logged out and menu class is called 
				Menu menu = new Menu();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} 
		
		frame.dispose();
		}
		}
	}

		

