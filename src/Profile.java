import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	JButton flight = new JButton();
	JButton back = new JButton("Back");
	JButton confirm = new JButton("Confirm Cancellation");
	JFrame frame =  new JFrame(); 
	
	
	public Profile () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		
	    frame.getContentPane().setBackground(Color.white);
	    back.setBounds(200, 500, 200, 75);
		back.setFocusable(false);
		back.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		back.addActionListener(this);
		back.setBackground(Color.white);
	    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBounds(50,150,800,800);
		JLabel info = new JLabel("Username     Password              Type                                Class               Destination            Departure                   Adult Pass.              Child Pass.");
		 info.setFont(new Font("Times New Roman", Font.BOLD, 10));
		 panel.add(info);
		 frame.getContentPane().add(panel);
		
	    
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
				flight = new JButton(firstName+"          "+lastName+"          "+type+"          "+classF+"          "+travelDestination+"          "+departure+"              "+adultPass+"         "+childPass);
				 //JLabel flight = new JLabel(firstName+"          "+lastName+"          "+type+"          "+classF+"          "+travelDestination+"          "+departure+"              "+adultPass+"         "+childPass);
				 flight.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				 flight.addActionListener(this);
				 panel.add(flight);
				 frame.getContentPane().add(panel);
				 flight.addActionListener(new ActionListener() {
	    			  @Override
	    		      public void actionPerformed(ActionEvent e) {
	    				  int result = JOptionPane.showConfirmDialog(frame, "Do you want to cancel the flight?");

	    				  if (result  == JOptionPane.YES_OPTION) {
	    					 removeRecord("FlightHistory.txt", firstName+lastName+type+classF+travelDestination+departure+adultPass+childPass);
	    					 frame.remove(flight);
	    					 frame.getContentPane().remove(panel);
	    					 System.out.println(flight);
	    					 System.out.println("here");
	    						
	    						
	    				  } else if (result  == JOptionPane.NO_OPTION) {
	    				       // No button was pressed
	    				  }
	    		         }
	    		      });
	    		      frame.getContentPane().add(panel);    
	    		   }
				   
				    		   
				    		  
				      }
			
			
			
		
		buffer.close();
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
		
		
	}
	

	
	catch(IOException err) {
		JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE);
	}
		
	    
	
	

	
	}
	
	public static void removeRecord(String filepath, String removeLine)
	{
		System.out.println("here");
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		String currentLine;
		
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			
			while((currentLine = br.readLine())!= null) {
				if(!(currentLine.equals(removeLine))) {
					pw.println(currentLine);
				}
				
			}
			
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
			System.out.println("here");
		}
		
		catch(Exception e) {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE);
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
if(e.getSource() == back) {
			
			try {
				Welcome men2 = new Welcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			frame.dispose();
		
	}
		
	}

}

