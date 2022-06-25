import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


/**
 * This class allows the user to enter their username and password to enter the database
 * @author Shruthi Konduru
 *
 */
public class LogIn implements ActionListener {
	
	//creating JFrame
	JFrame frame = new JFrame();
	
	//creating buttons
	JButton next = new JButton("Sign In");
	
	//creating colors
	Color darkBlue = new Color(20, 64, 109);
	Color white =  new Color(255, 255, 255);
	
	//creating static variables
	public static String username;
	public static String pswrd;
	public static int flightPoints = 0;
	
	//creating text fields and associated labels
	JLabel userName, password; 
    	JTextField userTf; 
	JPasswordField pwrdTf;
    
    /**
     * This method displays a login page with text fields for the user to enter their username, password and then confirm it to go to the welcome page
     * @throws MalformedURLException
     */
	public LogIn () throws MalformedURLException{
		
		//set frame properties
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System: Sign In"); 
		frame.setResizable(false);
		frame.pack();
		frame.setSize(600, 350);

		//adding Jlabels for username and password
		userName = new JLabel("Enter Username:");  
		password = new JLabel("Enter Password:");  
		userName.setBounds(80, 30, 200, 30);  
		password.setBounds(80, 70, 200, 30);  
		
		//adding the textfields to input username and password
		userTf = new JTextField();  
		pwrdTf = new JPasswordField();  
		userTf.setBounds(300, 30, 200, 30);  
		pwrdTf.setBounds(300, 70, 200, 30); 
		
		//adding the next button to confirm input
		next.setBounds(150, 190, 200, 30);
		next.setFocusable(false);
		next.addActionListener(this);
		next.setBackground(darkBlue);

		//adding components to frame
		 frame.add(next);
		 frame.add(userName);  
		 frame.add(userTf);  
		 frame.add(password);  
		 frame.add(pwrdTf);  
	}

	/**
	 * This method uses ActionMouseListener to perform actions if a button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//if the next button is clicked:
		if (e.getSource() == next)  
        {  
			//store user input in a string
           username = userTf.getText();  
           pswrd = pwrdTf.getText();
           
           //validate string to make it exists within users.txt
           if (checkLogin(username, pswrd))  
           {  
        	   
        	   //load in the welcome page
        	   frame.dispose();
               try {
				Welcome welcome = new Welcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
           }  
           else  
           {  
        	   //display error message and force user to re-enter info
        	   JOptionPane.showMessageDialog(next, "Username or Password Invalid");  
        	   userTf.setText("");  
          	 pwrdTf.setText("");  
           }   
         }   

   }

	/**
	 * This program takes in the user's username and password and validates it to make sure their account exists within users.txt
	 * @param username: string
	 * @param pswrd: string
	 * @return true if account exists or false if account doesn't exist
	 */
	private boolean checkLogin(String username, String pswrd) {
		boolean flag = true; 
		
		//use file reader to read user.txt
		FileReader file;
		BufferedReader buffer;
		String input;
		String line = username+" "+pswrd; 
		try {
			file = new FileReader("UserDetails.txt");
			buffer = new BufferedReader(file);
			
			//if the line equals the password and username return true else false
			while((input = buffer.readLine()) != null) { // while not eof
				if (line.equals(input)) {
					buffer.close();
					return true; 
				}
				
			}
			
			flag = false; 
		}
		
	
		
		catch(IOException err) {
			//exception error message
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE);
		}
		
		return flag;
		
	}
		
	}
