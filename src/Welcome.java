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
public class Welcome implements ActionListener{
	
	JFrame frame = new JFrame();  //adding the frame
	JButton back = new JButton("BACK");  
	JLabel title = new JLabel();
	JLabel text1 = new JLabel();
	JLabel text2 = new JLabel();
	JLabel text3 = new JLabel();
	JPanel greyPanel = new JPanel();
	JPanel secondGreyPanel = new JPanel();
	Icon pfp = new ImageIcon("Images/profile.jpg");
	JButton profile = new JButton(pfp);
	Icon flight = new ImageIcon("Images/flight.png");
	JButton bookFlight = new JButton(flight);
	Icon lottery = new ImageIcon("Images/lottery.png");
	JButton PlayLottery = new JButton(lottery);
	
	Color grey = new Color(211, 211, 211);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
	public Welcome () throws MalformedURLException{
		
		//setting properties for JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
	    
	    //setting bounds for the profile image
	    frame.getContentPane().add(profile);
	    profile.setBounds(130, 180, 200, 200);
		profile.setFocusable(false);
		profile.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		profile.addActionListener(this);
		profile.setBackground(darkBlue); 
		profile.setBorder(border);
	    frame.pack();
	    
	    //adding a caption for the profile image
	    text1.setText("View Profile");
		text1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text1.setBounds(140,300,200,200);
		text1.setForeground(darkBlue);
	    frame.pack();
	    
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
	    text2.setText("Book a flight");
		text2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text2.setBounds(365,300,200,200);
		text2.setForeground(darkBlue);
	    
	    //setting bounds for the lottery image
	    PlayLottery.setBounds(580, 180, 200, 200);
	    PlayLottery.setFocusable(false);
	    PlayLottery.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	    PlayLottery.addActionListener(this);
	    PlayLottery.setBackground(grey); 
	    PlayLottery.setBorder(border);
	    frame.pack();
	    
	    //adding caption under the lottery button
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
	
		//adding the title
		title.setText("WELCOME");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(230,-230,650,650);
		title.setForeground(grayBlue);
		
		//adding grey panels to the top and bottom of the page
		greyPanel.setBackground(grey);
	    greyPanel.setBounds(0,0,900,100);
	    secondGreyPanel.setBackground(grey);
	    secondGreyPanel.setBounds(0,550,900,100);
			
	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
	    //adding frame components
		frame.add(back);
		frame.add(title);
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
	 * This method uses ActionMouseListener to load the different pages once the next button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		
		//uses if statement to load profile page
		if(e.getSource() == profile) {
				frame.dispose();
				try {
					Profile p = new Profile();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			
			frame.dispose();
			}
		
		//uses if statement to load book tickets page
		if(e.getSource() == bookFlight) {
			frame.dispose();
			try {
				ChooseFlights choose = new ChooseFlights();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		frame.dispose();
		}
		
		//uses if statement to load lottery page
		if(e.getSource() == PlayLottery) {
			frame.dispose();
			try {
				Lottery lottery = new Lottery();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		frame.dispose();
		}
		
		//uses if statement to load menu page
		if(e.getSource() == back) {
			frame.dispose();
			try {
				Menu menu = new Menu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		frame.dispose();
		}
		}
	}

		



