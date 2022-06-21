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

public class Lottery implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton next = new JButton("Next");
	JLabel title = new JLabel();
	JLabel light_title = new JLabel();
	JButton confirm = new JButton("Enter");;
	JLabel text = new JLabel();
	JLabel text2 = new JLabel();
	JPanel bluePanel = new JPanel();
	ImageIcon logo = new ImageIcon("Images/logo.jpg");
	Icon plane = new ImageIcon("Images/plane.png");
	JTextField guess = new JTextField(60);
	JLabel g = new JLabel("ENTER GUESS!");
	JLabel planeLabel = new JLabel(plane);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	int min = 1;
	int max = 100;
	int tries = 3;
	int random = (int)(Math.random()*(max-min+1)+min);
	String gue;
	
	public Lottery () throws MalformedURLException{
		System.out.println(random);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		//ImageIcon image = new ImageIcon("Images/logo.jpg");
		frame.setIconImage(logo.getImage());
		
	    frame.getContentPane().setBackground(Color.white);
	  

	    frame.pack();
	    
	    //setting bounds for the plane image
	    planeLabel.setBounds(350,150,500,500);
		
	    //adding the next button
	    next.setBounds(200, 500, 200, 75);
		next.setFocusable(false);
		next.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		next.addActionListener(this);
		next.setBackground(white);
	
		//add the title
		title.setText("LOTTERY TIME");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(100,-270,650,650);
		title.setForeground(darkBlue);
		
		//Add a blue panel to the left
		bluePanel.setBackground(grayBlue);
		bluePanel.setBounds(0,0,100,800);
		
		g.setBounds(150, 250, 150, 20);
		guess.setBounds(150, 280, 200, 100);
		
		confirm.setBounds(150, 400, 100, 50);
		confirm.setFocusable(false);
		confirm.addActionListener(this);
		confirm.setBackground(grayBlue);
	  
	    
		//adding our names
		frame.getContentPane().add(text);
	    frame.pack();
	    
	    text.setText("Welcome to CS Air's Guessing Game. Our generator has thought of a random number from 1 - 100.");
		text.setFont(new Font("Times New Roman", Font.BOLD, 18));
		text.setBounds(100,-250,800,800);
		text.setForeground(darkBlue);
		
		text2.setText("GUESS THE NUMBER AND WIN 1000 FLIGHT POINTS TO GET A FREE TRIP!");
		text2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		text2.setBounds(100,-200,800,800);
		text2.setForeground(darkBlue);
			
	    
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
		frame.add(next);
		frame.add(title);
		frame.add(light_title);
		frame.add(bluePanel);
		frame.add(text);
		frame.add(text2);
		frame.add(planeLabel);
		frame.add(g);
		frame.add(guess);
		frame.add(confirm);
		
		
		
			
	}
	
	private boolean checkInt(String str) {
		boolean flag = true; 
		
		int strInt = Integer.parseInt(str); 
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(!(Character.isDigit(cur))) {
				
				flag = false;
			}
			

		}
		
		return flag;
		
			
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == next) {
			try {
				Welcome welcom = new Welcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
		if (e.getSource() == confirm)  {  
           gue = guess.getText();    
           try {
           if (checkInt(gue))  
           {  
        	   if(Integer.parseInt(gue)==random) {
        		   JOptionPane.showMessageDialog(confirm, "You've guessed the right number! You've won 1000 points");
        		   LogIn.flightPoints+= 1000;
        		   frame.dispose();
    			   Welcome w = new Welcome();
        	   }
        	   else {
        		   JOptionPane.showMessageDialog(confirm, "WRONG GUESS, YOU HAVE "+(tries-1)+" TRIES LEFT");
        		   if(tries==1) {
        			   JOptionPane.showMessageDialog(confirm, "OUT OF LUCK, YOU'VE USED UP YOUR TRIES");
        			   frame.dispose();
        			   Welcome w = new Welcome();
        		   }
        		   tries--;
        		   guess.setText("");
        	   }
           } 
           else {
        	   JOptionPane.showMessageDialog(confirm, "Input is invalid");  
            	guess.setText("");  
              	
               }   
           }
           catch(Exception ee) {
        	   JOptionPane.showMessageDialog(confirm, "Input is invalid"); 
        	   guess.setText(""); 

           }
		
		
	}
}
}
