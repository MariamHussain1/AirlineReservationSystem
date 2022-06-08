
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

public class Menu implements ActionListener {
	JFrame frame = new JFrame();
	JButton aboutUs = new JButton("About Us");
	JButton logOut = new JButton("Exit");
	JButton logIn = new JButton("Log In");
	JButton signIn = new JButton("Sign Up");
	JLabel title = new JLabel();
	JLabel light_title = new JLabel();
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	public Menu () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System: Menu"); 
		frame.setResizable(false);
		
		
		 frame.pack();
		 frame.setSize(900,800);
		 
		 
		 
		logIn.setBounds(250, 600, 200, 75);
		logIn.setFocusable(false);
		logIn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		logIn.addActionListener(this);
		logIn.setBackground(darkBlue); // why does dark blue not work 
		
		
		aboutUs.setBounds(50, 600, 200, 75);
		aboutUs.setFocusable(false);
		aboutUs.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		aboutUs.addActionListener(this);
		aboutUs.setBackground(darkBlue);
		
		logOut.setBounds(650, 600, 200, 75);
		logOut.setFocusable(false);
		logOut.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		logOut.addActionListener(this);
		logOut.setBackground(darkBlue);
		
		signIn.setBounds(450, 600, 200, 75);
		signIn.setFocusable(false);
		signIn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		signIn.addActionListener(this);
		signIn.setBackground(darkBlue);
		
		frame.add(aboutUs);
		frame.add(logIn);
		frame.add(signIn); 
		frame.add(logOut); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aboutUs) {
			frame.dispose();
			try {
				AboutUs aboutUs = new AboutUs();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
					}
		
		if(e.getSource() == logIn) {
			frame.dispose();
			try {
				LogIn login = new LogIn ();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		
		if(e.getSource() == signIn) {
			try {
				SignIn signIn = new SignIn();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	
	if (e.getSource() == logOut) {
		frame.dispose();
		try {
		TitlePage titlePage = new TitlePage();
		}
		catch (MalformedURLException e1) {
			
		}
		
	}
	}
}
	

