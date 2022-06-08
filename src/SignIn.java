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
import javax.swing.JTextField;
import java.io.*;

public class SignIn implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton next = new JButton("Sign Up");
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	JLabel userName, confirmUserName, password, confirmPassword; 
    JTextField userTf1, userTf2, pwrdTf1, pwrdTf2;
    
	Icon profile = new ImageIcon("Images/profile.jpg");
	JLabel profileLabel = new JLabel(profile);
	
	public SignIn () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System: Sign Up"); 
		frame.setResizable(false);
		

		frame.pack();
		frame.setSize(600, 250);

		profileLabel.setBounds(50,180,200,200);
		profileLabel.setFocusable(false);

		userName = new JLabel("Create Username:");  
		confirmUserName = new JLabel("Confirm Username:");  
		password = new JLabel("Create Password:");  
		 confirmPassword = new JLabel("Confirm Password:"); 
		 userName.setBounds(80, 30, 200, 30);  
		 confirmUserName.setBounds(80, 70, 200, 30);  
		 password.setBounds(80, 110, 200, 30);  
		 confirmPassword.setBounds(80, 150, 200, 30); 
		 
		 userTf1 = new JTextField();  
		 userTf2 = new JTextField();  
		 pwrdTf1 = new JTextField();  
		 pwrdTf2 = new JTextField(); 
		 userTf1.setBounds(300, 30, 200, 30);  
		 userTf2.setBounds(300, 70, 200, 30); 
		 pwrdTf1.setBounds(300, 110, 200, 30);  
		 pwrdTf2.setBounds(300, 150, 200, 30); 

		next.setBounds(150, 190, 200, 30);
		next.setFocusable(false);
		//next.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		next.addActionListener(this);
		next.setBackground(darkBlue);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next)  
        {  
           String username = userTf1.getText();  
           String confirmUsername = userTf2.getText();   
           String pswrd = pwrdTf1.getText();  
           String confirmPswrd = pwrdTf2.getText();  
           if (username.equals(confirmUsername) && pswrd.equals(confirmPswrd) && (!(username.isEmpty()) && !(pswrd.isEmpty())))  
           {  
               try  
               {  
                addUser(username, pswrd);
               }  
               catch (Exception ex)   
               {  

               }  
           }  
           else  
           {  
        	   JOptionPane.showMessageDialog(next, "Username or Password Does Not Match");  
           }   
         }   
         else  
         {  
        	 userTf1.setText("");  
        	 userTf2.setText("");    
        	 pwrdTf1.setText("");  
        	 pwrdTf2.setText("");  
         }  
   } 
	public void addUser (String username, String password ) {
		// Source: https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
		try(FileWriter file = new FileWriter("UserDetails.txt", true);
			    BufferedWriter bw = new BufferedWriter(file);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(username+" "+password);
			    
			} 
		catch (IOException e) { }

		// Source: https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
		Object [] possibleValues = { "Log In", "Go back to Main menu"};
		Object selectedValue = JOptionPane.showInputDialog(null,"Sign Up successfull. Choose Log In to continue ", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
        
        if (selectedValue == possibleValues[0]) {
        	frame.dispose();
        	try {
				LogIn login = new LogIn();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        else if (selectedValue == possibleValues[1]) {
        	frame.dispose();
        	try {
				Menu menu = new Menu();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }			
		

	}
		
		
	}
		
	

