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

public class TitlePage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton next = new JButton("Next");
	JLabel title = new JLabel();
	JLabel light_title = new JLabel();
	JLabel text = new JLabel();
	JPanel bluePanel = new JPanel();
	ImageIcon logo = new ImageIcon("Images/logo.jpg");
	Icon plane = new ImageIcon("Images/plane.png");
	JLabel planeLabel = new JLabel(plane);
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	public TitlePage () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		//ImageIcon image = new ImageIcon("Images/logo.jpg");
		frame.setIconImage(logo.getImage());
		
	    frame.getContentPane().setBackground(Color.white);
	  
	    frame.getContentPane().add(planeLabel);

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
		title.setText("CS AIR");
		title.setFont(new Font("Times New Roman", Font.BOLD, 100));
		title.setBounds(200,-200,650,650);
		title.setForeground(darkBlue);
		
		//Add a blue panel to the left
		bluePanel.setBackground(grayBlue);
		bluePanel.setBounds(0,0,100,800);
		
	  
	    
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
		frame.add(bluePanel);
		frame.add(text);
		frame.add(planeLabel);
		
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == next) {
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
