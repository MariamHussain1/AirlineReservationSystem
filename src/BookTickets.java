import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class BookTickets implements ActionListener{
	
	String flightClass;
	
	JFrame frame = new JFrame();  //adding the frame
	JButton back = new JButton("BACK");  
	JLabel title = new JLabel();
	JButton eco = new JButton("Economy");
	JButton bus = new JButton("Business");
	JButton fir = new JButton("First Class");
	JTextField jt = new JTextField();
	
	Color grey = new Color(211, 211, 211);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
	
	public BookTickets (String destination, String time) throws MalformedURLException{
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		
	    frame.getContentPane().setBackground(Color.white);
	    
	    //adding economy class button
	    frame.getContentPane().add(eco);
	    eco.setBounds(50, 130, 150, 100);
		eco.setFocusable(false);
		eco.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		eco.addActionListener(this);
		eco.setBackground(grayBlue); 
		eco.setBorder(border);

	    frame.pack();
	    
	    
	    //adding business class button
	    frame.getContentPane().add(bus);
	    bus.setBounds(50, 240, 150, 100);
		bus.setFocusable(false);
		bus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bus.addActionListener(this);
		bus.setBackground(Color.white); 
		bus.setBorder(border);

	    frame.pack();
	    
	    
	  
	    
	    //adding firstclass button
	    frame.getContentPane().add(fir);
	    fir.setBounds(50, 350, 150, 100);
	    fir.setFocusable(false);
	    fir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    fir.addActionListener(this);
	    fir.setBackground(grey); 
	    fir.setBorder(border);

	    frame.pack();
	    
	
	    //adding the back button 
	    back.setBounds(50, 570, 150, 50);
	    back.setFocusable(false);
	    back.setFont(new Font("Times New Roman", Font.ITALIC, 30));
	    back.addActionListener(this);
	    back.setBackground(white);
	
		//add the title
		title.setText("Book Tickets");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(230,-230,650,650);
		title.setForeground(grayBlue);
		
	
			
	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
		frame.add(back);
		frame.add(title);
		frame.add(eco);
		frame.add(bus);
		frame.add(fir);
	
		
		
			
	}
	
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == bus) {
				//frame.dispose();
			flightClass = "Business";
			
			frame.dispose();
			}
		if(e.getSource() == fir) {
			frame.dispose();
			flightClass = "First";
			
		
		frame.dispose();
		}
		if(e.getSource() == eco) {
			frame.dispose();
			flightClass = "Economy";
		}
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

		
