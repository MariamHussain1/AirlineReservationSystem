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
	
	public Profile () throws MalformedURLException{

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
				
	
				
			}
			
			
			
		}
		buffer.close();
		
		
	}
	

	
	catch(IOException err) {
		JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE);
	}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
