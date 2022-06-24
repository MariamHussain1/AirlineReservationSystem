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
 * @author Shruthi Konduru
 * This class displays the credits page which includes our works cited 
 */
public class Credits implements ActionListener{
	// defining components of class
	JButton goback = new JButton("Main Menu");
    JFrame credit = new JFrame();
	Icon worksCited = new ImageIcon("Images/ARScreditpage.png");
	JLabel creds = new JLabel(worksCited);

	public Credits () throws MalformedURLException {
		// setting frame properties 
		credit.setDefaultCloseOperation(credit.DISPOSE_ON_CLOSE);
		credit.setLayout(null);
		credit.setVisible(true);
		credit.setTitle("Airline Reservation System: Credits"); 
		credit.setResizable(false);
		credit.pack();
		credit.setSize(900,800);
		
		creds.setBounds(0,55,900,650);
		
		credit.add(creds);


		// setting button properties 
		goback.setBounds(400, 660, 150, 75);
		goback.setFocusable(false);
		goback.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		goback.addActionListener(this);
		goback.setBackground(Color.white);

		creds.setBounds(0,55,900,650);
		
		// adding elements to frame
		credit.add(creds);
		credit.add(goback); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// a on click the back button goes to the about us page
		if (e.getSource()==goback) {
			credit.dispose(); 

			try {
				Menu menu = new Menu();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} 
		}
		
	}

}
