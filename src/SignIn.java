import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;

/**
 * This class allows the user to create their username and password to be stored in UserDetails.txt
 * @author Shruthi Konduru and Mariam Hussain 
 */
public class SignIn implements ActionListener {

	//creating JFrame 
	JFrame frame = new JFrame();

	//Creating button to Sign up 
	JButton next = new JButton("Sign Up");

	//Defining colours 
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);

	// Creating text fields and associated labels for user input 
	JLabel userName, confirmUserName, password, confirmPassword; 
	JTextField userTf1, userTf2; 
	JPasswordField pwrdTf1, pwrdTf2;

	/**
	 * This method displays the sign up page with text fields for user input that becomes stored in the UserDetails.txt
	 * @throws MalformedURLException
	 */

	public SignIn () throws MalformedURLException{

		// frame properties 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System: Sign Up"); 
		frame.setResizable(false);


		frame.pack();
		frame.setSize(600, 350);

		// creating JLabels for username, confirming username, password and confirming password 
		userName = new JLabel("Create Username:");  
		confirmUserName = new JLabel("Confirm Username:");  
		password = new JLabel("Create Password:");  
		confirmPassword = new JLabel("Confirm Password:"); 
		userName.setBounds(80, 30, 200, 30);  
		confirmUserName.setBounds(80, 70, 200, 30);  
		password.setBounds(80, 110, 200, 30);  
		confirmPassword.setBounds(80, 150, 200, 30); 

		// creating the textfields for user input 
		userTf1 = new JTextField();  
		userTf2 = new JTextField();  
		pwrdTf1 = new JPasswordField();  
		pwrdTf2 = new JPasswordField(); 
		userTf1.setBounds(300, 30, 200, 30);  
		userTf2.setBounds(300, 70, 200, 30); 
		pwrdTf1.setBounds(300, 110, 200, 30);  
		pwrdTf2.setBounds(300, 150, 200, 30); 

		// creating the next button to act as a confirm button 
		next.setBounds(150, 190, 200, 30);
		next.setFocusable(false);
		next.addActionListener(this);
		next.setBackground(darkBlue);

		//adding components to frame
		frame.add(next);
		frame.add(userName);  
		frame.add(confirmUserName);  
		frame.add(userTf1);  
		frame.add(password);  
		frame.add(userTf2);  
		frame.add(confirmPassword);
		frame.add(pwrdTf1);  
		frame.add(pwrdTf2);  

	}

	/**
	 * This method uses ActionMouseListener to perform actions if a button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next)  
		{  
			// once next is clicked, user input is stored in a string 
			String username = userTf1.getText();  
			String confirmUsername = userTf2.getText();   
			String pswrd = pwrdTf1.getText();  
			String confirmPswrd = pwrdTf2.getText();  

			// Validate if the user has correctly confirmed their username and password  
			if (username.equals(confirmUsername) && pswrd.equals(confirmPswrd) && (!(username.isEmpty()) && !(pswrd.isEmpty())))  
			{  
				try  
				{  
					//method is called to add user to UserDetails.txt
					addUser(username, pswrd);
				}  
				catch (Exception ex)   
				{  

				}  
			}  
			else  
			{   
				// If user input does not match, user is informed using a JOptionPane
				JOptionPane.showMessageDialog(next, "Username or Password Does Not Match");  
			}   
		}   
		else  
		{  
			// If user input does not match, the textfields are reset for user to re-input 
			userTf1.setText("");  
			userTf2.setText("");    
			pwrdTf1.setText("");  
			pwrdTf2.setText("");  
		}  
	} 
	/**
	 * This program takes in the users input and adds it to the UserDetails.txt file. 
	 * @param username: string
	 * @param password: string 
	 */
	public void addUser (String username, String password ) {

		// This code was made while using the Source: https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java

		//Username and password is written to UserDetails.txt text file
		try(FileWriter file = new FileWriter("UserDetails.txt", true);
				BufferedWriter bw = new BufferedWriter(file);
				PrintWriter out = new PrintWriter(bw))
		{
			out.println(username+" "+password);

		} 
		catch (IOException e) { 

		}


		// This code was made while using the Source: https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html

		//Once the user details have been written to the txt file, a JOptionPane is displayed so the user can choose to Log In or go back to Main Menu 
		// stores options in an array and uses elemts to display to JOption Pane
		Object [] possibleValues = { "Log In", "Go back to Main menu"};
		Object selectedValue = JOptionPane.showInputDialog(null,"Sign Up successfull. Choose Log In to continue ", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);

		//Uses if statements to load different instances based on option chosen in JOptionPane
		if (selectedValue == possibleValues[0]) {
			frame.dispose();
			try {
				LogIn login = new LogIn();
			} catch (MalformedURLException e) {

				e.printStackTrace();
			} 
		}
		else if (selectedValue == possibleValues[1]) {
			frame.dispose();
			try {
				Menu menu = new Menu();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} 
		}			


	}

}
