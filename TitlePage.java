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

public class TitlePage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton next = new JButton("Next");
	JLabel title = new JLabel();
	JLabel light_title = new JLabel();
	Color grayBlue = new Color(102, 153, 204);
	Color darkBlue = new Color(20, 64, 109);
	Color white = new Color(255, 255, 255);
	
	public TitlePage () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		
		ImageIcon image = new ImageIcon("Images/logo.jpg");
		frame.setIconImage(image.getImage());
		
		Icon plane = new ImageIcon("Images/plane.png");
		
	    JLabel planeLabel = new JLabel(plane);
	    frame.getContentPane().setBackground(Color.white);
	  
	    frame.getContentPane().add(planeLabel);

	    frame.pack();
	    
	    planeLabel.setBounds(350,100,500,500);
			
	    frame.getContentPane().setBackground(Color.white);

	    frame.pack();
	    frame.setSize(900,800);

		
		next.setBounds(400, 600, 200, 75);
		next.setFocusable(false);
		next.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		next.addActionListener(this);
		next.setBackground(white);
	
		title.setText("CS AIR");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(105,-190,650,650);
		title.setForeground(darkBlue);
	
		frame.add(next);
		frame.add(title);
		frame.add(light_title);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == next) {
			Menu menuPage = new Menu();
			frame.dispose();
		}
		
	}
}
