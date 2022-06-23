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
import javax.swing.JPanel;

/**
 * This class shows a page with our names and class and the title of our program
 * @author Mariam Hussain & Shruthi Konduru 
 *
 */
public class TitlePage implements ActionListener {
	
	//adding JFrame
	JFrame frame = new JFrame();
	
	//creating an image
	ImageIcon logo = new ImageIcon("Images/logo.jpg");
	Icon plane = new ImageIcon("Images/plane.png");
	
	//creating buttons
	JButton next = new JButton("Next");

	//creating JLabels
	JLabel title = new JLabel();
	JLabel light_title = new JLabel();
	JLabel text = new JLabel();
	JLabel planeLabel = new JLabel(plane);

	//creating a JPanel
	JPanel bluePanel = new JPanel();

	//creating colors
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	public TitlePage () throws MalformedURLException{
		
		//adding frame properties
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
	
		//adding the title
		title.setText("CS AIR");
		title.setFont(new Font("Times New Roman", Font.BOLD, 100));
		title.setBounds(200,-200,650,650);
		title.setForeground(darkBlue);
		
		//Adding a blue panel to the left
		bluePanel.setBackground(grayBlue);
		bluePanel.setBounds(0,0,100,800);
	    
		//adding our names
	    text.setText("ICS3U7 Shruthi Konduru and Mariam Hussain");
		text.setFont(new Font("Times New Roman", Font.BOLD, 20));
		text.setBounds(150,-300,650,650);
		text.setForeground(darkBlue);
			
	    //set frame properties
		frame.getContentPane().setBackground(Color.white);
	    frame.pack();
	    frame.setSize(900,800);
	
	    //add components to frame
		frame.add(next);
		frame.add(title);
		frame.add(light_title);
		frame.add(bluePanel);
		frame.add(text);
		frame.add(planeLabel);
		
		
			
	}
	/**
	 * This method uses ActionMouseListener to perform actions if a button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == next) {
			//if next is clicked the menu screen is loaded
			try {
				Menu menuPage = new Menu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
		
	}
}
