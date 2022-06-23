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

/**
 * 
 * @author Mariam Hussain
 *
 */

public class Lottery implements ActionListener {
	
	//made JFrame
	JFrame frame = new JFrame();
	
	//added images
	Icon plane = new ImageIcon("Images/plane.png");
	
	//made buttons
	JButton next = new JButton("Back");
	JButton confirm = new JButton("Enter");
	
	//made JLabels
	JLabel title = new JLabel();
	JLabel light_title = new JLabel();
	JLabel text = new JLabel();
	JLabel text2 = new JLabel();
	JLabel g = new JLabel("ENTER GUESS!");
	JLabel planeLabel = new JLabel(plane);
	
	//made JPanel
	JPanel bluePanel = new JPanel();
	
	//added text field
	JTextField guess = new JTextField(60);
	
	//added colors
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	//variables
	int min = 1;
	int max = 100;
	int tries = 3;
	int random = (int)(Math.random()*(max-min+1)+min);
	String gue;
	
	/**
	 * This class shows a lottery class where the user has 3 tries to guess a random number from 1-100 and they guess right they win a free flight
	 * @throws MalformedURLException
	 */
	public Lottery () throws MalformedURLException{
		//prints number to console
		System.out.println(random);
		
		//frame properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
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
		
		//Adding the text labels on to page
		g.setBounds(150, 250, 150, 20);
		guess.setBounds(150, 280, 200, 100);
		
		//adding confirm button for the guess
		confirm.setBounds(150, 400, 100, 50);
		confirm.setFocusable(false);
		confirm.addActionListener(this);
		confirm.setBackground(grayBlue);
	  
	    //setting the instructins
	    text.setText("Welcome to CS Air's Guessing Game. Our generator has thought of a random number from 1 - 100.");
		text.setFont(new Font("Times New Roman", Font.BOLD, 18));
		text.setBounds(100,-250,800,800);
		text.setForeground(darkBlue);
		
		//setting the instructions
		text2.setText("GUESS THE NUMBER AND WIN A FREE TRIP!");
		text2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		text2.setBounds(100,-200,800,800);
		text2.setForeground(darkBlue);
			
	    //set properties for the frame
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
	    //add components to frame
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
	/**
	 * This method checks the input into the text field and makes sure that it is a number
	 * @param str: string
	 * @return true if the string is a proper number or false
	 */
	private boolean checkInt(String str) {
		boolean flag = true; 
		//parses string to int
		int strInt = Integer.parseInt(str); 
		//uses for loop to traverse string and make sure every char is a digit
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(!(Character.isDigit(cur))) {
				
				flag = false;
			}
			

		}
		
		return flag;
		
			
		}
	
	/**
	 * This method uses ActionMouseListener to perform actions based on buttons clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {	
		//if next is pressed welcome page is loaded
		if(e.getSource() == next) {
			try {
				Welcome welcom = new Welcome();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
		
		//if confirmed is pressed:
		if (e.getSource() == confirm)  {  
			
			//stores input from text field in variable 
           gue = guess.getText();    
           try {
        	   
        	   //checks if gue equals the random number
           if (checkInt(gue))  
           {  
        	   if(Integer.parseInt(gue)==random) {
        		   
        		   //display congratualtions message and increment flight points by 1000
        		   JOptionPane.showMessageDialog(confirm, "You've guessed the right number! You've won a free flight!");
        		   LogIn.flightPoints += 1000;
        		   frame.dispose();
    			   Welcome w = new Welcome();
        	   }
        	   else {
        		   //show message and display number of tries left
        		   JOptionPane.showMessageDialog(confirm, "WRONG GUESS, YOU HAVE "+(tries-1)+" TRIES LEFT");
        		   //deduct a try (3 to start)
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
        	   //for errors force user to re-enter info
        	   JOptionPane.showMessageDialog(confirm, "Input is invalid");  
            	guess.setText("");  
              	
               }   
           }
           //for errors: force user to re-enter info
           catch(Exception ee) {
        	   JOptionPane.showMessageDialog(confirm, "Input is invalid"); 
        	   guess.setText(""); 

           }
		
		
	}
}
}
