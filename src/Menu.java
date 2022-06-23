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

/**
 * 
 * @author Mariam Hussain
 *
 */
public class Menu implements ActionListener {
	//adding JFrame
	JFrame frame = new JFrame();
	
	//creating buttons
	JButton aboutUs = new JButton("About Us");
	JButton logOut = new JButton("Exit");
	JButton logIn = new JButton("Log In");
	JButton signIn = new JButton("Sign Up");

	//creating image
	Icon main = new ImageIcon("Images/mainMenu.jpg");

	//creating JLabel
	JLabel title = new JLabel();
	JLabel mainImage = new JLabel(main);
	
	//creating colors
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	/**
	 * This program shows 4 buttons where the user can log in, sign in, see the about us page, or exit the program
	 * @throws MalformedURLException
	 */
	public Menu () throws MalformedURLException{
		
		//add frame properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System: Menu"); 
		frame.setResizable(false);
		frame.pack();
		frame.setSize(900,800);
		 
		//setting bounds for the plane image
		mainImage.setBounds(0,0,900,900);
		 
		 
		//adding log in button
		logIn.setBounds(50, 100, 200, 75);
		logIn.setFocusable(false);
		logIn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		logIn.addActionListener(this);
		logIn.setBackground(Color.white); // why does dark blue not work 
		
		//adding about us button
		aboutUs.setBounds(50, 250, 200, 75);
		aboutUs.setFocusable(false);
		aboutUs.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		aboutUs.addActionListener(this);
		aboutUs.setBackground(Color.white);
		
		//adding logout button
		logOut.setBounds(50, 325, 200, 75);
		logOut.setFocusable(false);
		logOut.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		logOut.addActionListener(this);
		logOut.setBackground(Color.white);
		
		//adding sign in button
		signIn.setBounds(50, 175, 200, 75);
		signIn.setFocusable(false);
		signIn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		signIn.addActionListener(this);
		signIn.setBackground(Color.white);
		
		//adding components to frame
		frame.add(aboutUs);
		frame.add(logIn);
		frame.add(signIn); 
		frame.add(logOut);
		frame.add(mainImage);
	}
	
	/**
	 * This method uses ActionMouseListener to perform actions based on what button gets clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aboutUs) {
			frame.dispose();
			try {
				//if aboutUs button is clicked the AboutUs class is called
				AboutUs aboutUs = new AboutUs();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
					}
		
		if(e.getSource() == logIn) {
			frame.dispose();
			try {
				//if login button is clicked the login class is called
				LogIn login = new LogIn ();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		
		if(e.getSource() == signIn) {
			try {
				//if sign in button is clicked the signin class is called
				SignIn signIn = new SignIn();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	
	if (e.getSource() == logOut) {
		frame.dispose();
		  //if logout is clicked, the user leaves the program
		
			
		
		
	}
	}
}
	

