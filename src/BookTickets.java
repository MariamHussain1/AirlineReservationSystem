import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class BookTickets implements ActionListener{
	
	
	JFrame frame = new JFrame();  //adding the frame
	JButton back = new JButton("BACK");
	JButton confirm = new JButton("Confirm");
	JLabel title = new JLabel();
	JLabel text = new JLabel();
	JButton eco = new JButton(LogIn.username);
	JButton bus = new JButton("Business");
	JButton fir = new JButton("First Class");
	
	Color grey = new Color(211, 211, 211);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	public static String flightClass;
	public static String pass;
	public static String children;
	JLabel p = new JLabel("Passenger Count");
	JLabel p2 = new JLabel("#Of Child Passengers (under 12)");
    JTextField passengers = new JTextField(30);
    JTextField child = new JTextField(30);
	
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
	    back.setBounds(50, 570, 150, 50);
	    back.setFocusable(false);
	    back.setFont(new Font("Times New Roman", Font.ITALIC, 30));
	    back.addActionListener(this);
	    back.setBackground(white);
	
		//add the title
		title.setText("Book Tickets");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(130,-230,650,650);
		title.setForeground(grayBlue);
		
		//add label
		text.setText("Choose Flight Class");
		text.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		text.setBounds(50,-140,500,650);
		text.setForeground(grayBlue);
		
		//add textfield
		p.setBounds(300, 150, 200, 30);
		p2.setBounds(300, 250, 200, 30);
		  
		passengers.setBounds(300, 200, 200, 30);  
		child.setBounds(300, 300, 200, 30); 
		
		confirm.setBounds(300, 350, 100, 50);
		confirm.setFocusable(false);
		confirm.addActionListener(this);
		confirm.setBackground(grayBlue);
		
	
			
	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
	    frame.add(text);
		frame.add(back);
		frame.add(title);
		frame.add(eco);
		frame.add(bus);
		frame.add(fir);
		frame.add(p);
		frame.add(passengers); 
		frame.add(p2);
		frame.add(child);
		frame.add(confirm);
		
		
			
	}
	private boolean checkInt(String str) {
		boolean flag = true; 
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(!(Character.isDigit(cur))) {
				flag = false;
			}
		}
		
		return flag;
		
			
		}
	
		
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm)  {  
           pass = passengers.getText();  
           children = child.getText();  
           if (checkInt(pass)&&checkInt(children))  
           {  
        	   frame.dispose();
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
		if(e.getSource() == bus) {
				
			flightClass = "Business";
			bus.setBackground(darkBlue);
			eco.setBackground(grayBlue);
			fir.setBackground(grey);
			System.out.println(flightClass);
			
			
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
		if(e.getSource() == back) {
			frame.dispose();
			try {
				ChooseFlights flights = new ChooseFlights();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		frame.dispose();
		}
		}
	
}


		
