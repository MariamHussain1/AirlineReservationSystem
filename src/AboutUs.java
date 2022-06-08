import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AboutUs implements ActionListener{
	Color darkBlue = new Color(20, 64, 109);
	JFrame aboutUs = new JFrame();
	JButton back = new JButton("Go Back To Menu");
	
	public AboutUs () throws MalformedURLException{

	aboutUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	aboutUs.setLayout(null);
	aboutUs.setVisible(true);
	aboutUs.setTitle("Airline Reservation System: About Us"); 
	aboutUs.setResizable(false);
	
	
	aboutUs.pack();
	aboutUs.setSize(900,800);
	
	back.setBounds(150, 600, 200, 75);
	back.setFocusable(false);
	back.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	back.addActionListener(this);
	back.setBackground(darkBlue);
	
	
	aboutUs.add(back); 
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			
			try {
				Menu men2 = new Menu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			aboutUs.dispose();
		
	}
	}
}
