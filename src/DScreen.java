import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DScreen implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton d1 = new JButton("Montreal");
	JButton d2 = new JButton("Victoria");
	JButton d3 = new JButton("Iqaluit");
	JButton d4 = new JButton("Halifax");
	JLabel title = new JLabel();
	JLabel text = new JLabel();
	JPanel bluePanel = new JPanel();
	ImageIcon logo = new ImageIcon("Images/logo.jpg");
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color grey = new Color(211, 211, 211);
	
	Border border = BorderFactory.createLineBorder(darkBlue, 5);
	
	public DScreen () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		//ImageIcon image = new ImageIcon("Images/logo.jpg");
		frame.setIconImage(logo.getImage());
		
	    frame.getContentPane().setBackground(Color.white);
	    
	  //add the title
	  		title.setText("Choose Destination:");
	  		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
	  		title.setBounds(60,-160,500,500);
	  		title.setForeground(Color.black);
	 
	    //frame.getContentPane().add(profile);
	    d1.setBounds(50, 100, 200, 75);
		d1.setFocusable(false);
		d1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		d1.addActionListener(this);
		d1.setBackground(grey); 
	    frame.pack();
	    
	    
	    //setting bounds for the flight image
	    frame.getContentPane().add(d2);
	    d2.setBounds(50, 250, 200, 75);
	    d2.setFocusable(false);
	    d2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	    d2.addActionListener(this);
	    d2.setBackground(Color.white); 

	    frame.pack();
	    
	    //setting bounds for the lottery image
	    frame.getContentPane().add(d3);
	    d3.setBounds(50, 325, 200, 75);
	    d3.setFocusable(false);
	    d3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	    d3.addActionListener(this);
	    d3.setBackground(grey); 

	    frame.pack();
	    
	    d4.setBounds(50, 175, 200, 75);
	    d4.setFocusable(false);
	    d4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	    d4.addActionListener(this);
	    d4.setBackground(Color.white);
	    
	    frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
		frame.add(title);
		frame.add(d1);
		frame.add(d2);
		frame.add(d3);
		frame.add(d4);
	    
	    
	}
	    
	
	
	  


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	}