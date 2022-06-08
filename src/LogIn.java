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

public class LogIn implements ActionListener {
	JFrame frame = new JFrame();
	JButton next = new JButton("Sign Up");
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	JLabel userName, password; 
    JTextField userTf, pwrdTf;
    
	public LogIn () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System: Sign In"); 
		frame.setResizable(false);
		

		frame.pack();
		frame.setSize(600, 250);

		userName = new JLabel("Enter Username:");  
		password = new JLabel("Enter Password:");  
		userName.setBounds(80, 30, 200, 30);  
		password.setBounds(80, 70, 200, 30);  
		 
		userTf = new JTextField();  
		pwrdTf = new JTextField();  
		userTf.setBounds(300, 30, 200, 30);  
		pwrdTf.setBounds(300, 70, 200, 30); 
		 
		 next.setBounds(150, 190, 200, 30);
		 next.setFocusable(false);
		 //next.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		 next.addActionListener(this);
		 next.setBackground(darkBlue);

		 frame.add(next);
		 frame.add(userName);  
		 frame.add(userTf);  
		 frame.add(password);  
		 frame.add(pwrdTf);  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next)  
        {  
           String username = userTf.getText();  
           String pswrd = pwrdTf.getText();  
           if (checkLogin(username, pswrd))  
           {  
        	   frame.dispose();
               try {
				AppWelcome welcome = new AppWelcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
           }  
           else  
           {  
        	   JOptionPane.showMessageDialog(next, "Username or Password Invalid");  
        	   userTf.setText("");  
          	 pwrdTf.setText("");  
           }   
         }   

   }

	private boolean checkLogin(String username, String pswrd) {
		boolean flag = true; 
		FileReader file;
		BufferedReader buffer;
		String input;
		String line = username+" "+pswrd; 
		try {
			file = new FileReader("UserDetails.txt");
			buffer = new BufferedReader(file);
			
			while((input = buffer.readLine()) != null) { // while not eof
				if (line.equals(input)) {
					buffer.close();
					return true; 
				}
				
			}
			
			flag = false; 
		}
		
	
		
		catch(IOException err) {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE);
		}
		
		return flag;
		
	}
		
	}
