import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class Welcome implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton next = new JButton("Next");
	JLabel title = new JLabel();
	JLabel light_title = new JLabel();
	JLabel text = new JLabel();
	JPanel greyPanel = new JPanel();
	JPanel secondGreyPanel = new JPanel();
	
	Icon profile = new ImageIcon("Images/profile.jpg");
	JLabel profileLabel = new JLabel(profile);
	
	Color grey = new Color(211, 211, 211);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
	public Welcome () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		
	    frame.getContentPane().setBackground(Color.white);
	    frame.getContentPane().addMouseListener(new ScreenClick());

	  
	    frame.getContentPane().add(profileLabel);

	    frame.pack();
	    
	    //setting bounds for the plane image
	    profileLabel.setBounds(50,180,200,200);
	    profileLabel.setFocusable(false);
	    // set the border of this component
	    profileLabel.setBorder(border);
		
		
		
	    //adding the next button
	    next.setBounds(200, 500, 200, 75);
		next.setFocusable(false);
		next.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		next.addActionListener(this);
		next.setBackground(white);
		
		next.addActionListener(this);
	
		//add the title
		title.setText("WELCOME");
		title.setFont(new Font("Times New Roman", Font.ITALIC, 80));
		title.setBounds(260,-230,650,650);
		title.setForeground(grayBlue);
		
		//Add grey panels to bottom and top of page
		greyPanel.setBackground(grey);
	    greyPanel.setBounds(0,0,900,100);
	    secondGreyPanel.setBackground(grey);
	    secondGreyPanel.setBounds(0,550,900,100);
		
	  
	    
		//adding our names
		frame.getContentPane().add(text);
	    frame.pack();
	    
	    text.setText("ICS3U7 Shruthi Konduru and Mariam Hussain");
		text.setFont(new Font("Times New Roman", Font.BOLD, 20));
		text.setBounds(150,-300,650,650);
		text.setForeground(darkBlue);
			
	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
		frame.add(next);
		frame.add(title);
		frame.add(light_title);
		frame.add(greyPanel);
		frame.add(secondGreyPanel);
		frame.add(text);
		frame.add(profileLabel);
		
		
			
	}
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == next) {
			Menu menuPage = new Menu();
			frame.dispose();
		}
		
	}
		


}
