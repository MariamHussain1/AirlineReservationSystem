import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JFrame;

public class AppWelcome implements ActionListener {
	JFrame frame = new JFrame();
	public AppWelcome () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System: Welcome to CS Air"); 
		frame.setResizable(false);
		

		frame.pack();
		frame.setSize(600, 250);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
