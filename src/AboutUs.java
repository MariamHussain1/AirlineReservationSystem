
/**
 * @author Mariam Hussain
 * This class loads an image to display information about the program
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.PopupFactory;

public class AboutUs implements ActionListener{
	
	//declaration of components
	Color darkBlue = new Color(20, 64, 109);
	JFrame aboutUs = new JFrame();
	JButton back = new JButton("Main Menu");
	JButton credits = new JButton("Credits"); 
	Icon pic = new ImageIcon("Images/about.jpg");
	JLabel background = new JLabel(pic);
	
	public AboutUs () throws MalformedURLException{
		
	//setting frame properties
	aboutUs.setDefaultCloseOperation(aboutUs.DISPOSE_ON_CLOSE);
	aboutUs.setLayout(null);
	aboutUs.setVisible(true);
	aboutUs.setTitle("Airline Reservation System: About Us"); 
	aboutUs.setResizable(false);
	aboutUs.pack();
	aboutUs.setSize(900,800);
	
	//setting bounds for the background image
    background.setBounds(0,20,900,650);
	
    //adding the back button
	back.setBounds(400, 660, 150, 75);
	back.setFocusable(false);
	back.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	back.addActionListener(this);
	back.setBackground(Color.white);
	
	credits.setBounds(690, 300, 150, 75);
	credits.setFocusable(false);
	credits.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	credits.addActionListener(this);
	credits.setBackground(Color.white);
	
	//adding components on to frame
	aboutUs.add(back); 
	aboutUs.add(credits); 
	aboutUs.add(background);
	}

	/**
	 * This method uses ActionMouseListener to load objects if a button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		//uses if statement to load credits page if credits button is clicked 
		if (e.getSource() == credits) {
			try {
				Credits credits = new Credits();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} 

		}
		//uses if statement to load main menu if back button is clicked
		if(e.getSource() == back) {
			aboutUs.dispose();
			try {
				Menu au = new Menu();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}

		
	}


	}
}
