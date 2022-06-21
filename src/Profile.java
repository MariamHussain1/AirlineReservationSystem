import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

public class Profile implements ActionListener{
	public String firstName; 
	public String lastName; 
	public String type; 
	public String classF; 
	public String travelDestination; 
	public String departure; 
	public String adultPass; 
	public String childPass; 
	JPanel panel = new JPanel(); 
	public static int i; 
	public static int j; 
	JFrame frame =  new JFrame(); 
	
	
	public Profile () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		
	    frame.getContentPane().setBackground(Color.white);
	    
	FileReader file;
	BufferedReader buffer;
	String input;
	String line = LogIn.username+" "+LogIn.pswrd; 
	try {
		
		file = new FileReader("FlightHistory.txt");
		buffer = new BufferedReader(file);
		
		while((input = buffer.readLine()) != null) { // while not eof
			 String inputArray[] = input.split(" "); 
			if ((line).equals(inputArray[0]+" "+inputArray[1])) {
				firstName = inputArray[0]; 
				lastName = inputArray[1]; 
				type = inputArray[2]; 
				classF = inputArray[3]; 
				travelDestination = inputArray[4]; 
				departure = inputArray[5]; 
				adultPass = inputArray[6]; 
				childPass = inputArray [7]; 
				System.out.println(firstName+lastName+type+classF+travelDestination+departure+adultPass+childPass);
				
				// repeating 10 times 
				 panel.setBounds(50,150,800,800);
				    panel.setLayout(new GridLayout(10,0));  
				      JLabel[]username = new JLabel[10];
				      for(i = 0; i<10; i++) {

				    		  username[i] = new JLabel(type);
				    		//  System.out.println(username[i]); 
						   //username.setText(firstName);
								username[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
				    		      panel.add(username[i]);
				    		      frame.getContentPane().add(panel);    
				    		   }
				    		  
				      }
	
				
			}
			
			
			
		
		buffer.close();
		
		
	}
	

	
	catch(IOException err) {
		JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE);
	}
		
	    
	   
	      
	      frame.pack(); 
	      frame.setSize(900, 800);
	      frame.add(panel); 
	      
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
