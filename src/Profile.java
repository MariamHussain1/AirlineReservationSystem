/**
 * @author Shruthi Konduru and Mariam Hussain 
 * 
 * This class displays all of the flights the user has booked by reading the FlightHistory.txt file, it also allows user to 
 * cancel their flight by clicking on the flight button. 
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Profile implements ActionListener{
	//Adding frame
	JFrame frame =  new JFrame(); 

	// All the elements being displayed as apart of the user's flight history 
	public String firstName; 
	public String lastName; 
	public String type; 
	public String classF; 
	public String travelDestination; 
	public String departure; 
	public String adultPass; 
	public String childPass; 

	// Defining the panel to display the flights from the txt file
	JPanel panel = new JPanel(); 

	//creating static variable for the for loop used to display elements of each flight using flow layout 
	public static int i; 
	public static int j;

	//Defining the JButtons
	JButton flight = new JButton();
	JButton back = new JButton("Main Menu");
	JButton confirm = new JButton("Confirm Cancellation");

	// Creating the on-screen text as JLabel
	JLabel title = new JLabel();

	// Defining the image
	Icon plane = new ImageIcon("Images/flighthistory.png");
	JLabel planee = new JLabel(plane); 

	/**
	 * This methods displays the objects defined onto the screen 
	 * @throws MalformedURLException
	 */
	public Profile () throws MalformedURLException{

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Airline Reservation System"); 
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.cyan);

		// Setting bounds of the plane Image
		planee.setBounds(0, 0, 900, 100); 

		// Creating the back button
		back.setBounds(760, 10, 90, 50);
		back.setFocusable(false);
		back.setFont(new Font("Times New Roman", Font.BOLD, 10));
		back.addActionListener(this);
		back.setBackground(Color.lightGray);

		//Using FlowLayout to display elements of the users Flights
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBounds(50,150,800,800);
		panel.setBackground(Color.white);

		//Adding the context of each element of each object stored in FlightHistory.txt
		JLabel info = new JLabel("Username     Password              Type                                Class                          Destination            Departure                   Adult Pass.     Child Pass.");
		info.setFont(new Font("Times New Roman", Font.BOLD, 10));

		panel.add(info);
		frame.getContentPane().add(panel);

		//Creating instructions for user
		title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		title.setText("Welcome to your profile. Click on a flight entry to cancel a flight: ");
		title.setBounds(50,85,900,100);




		// Reading the FlightHistory.txt file to find + display user's flights    
		FileReader file;
		BufferedReader buffer;
		String input;
		String line = LogIn.username+" "+LogIn.pswrd; 
		try {

			file = new FileReader("FlightHistory.txt");
			buffer = new BufferedReader(file);

			while((input = buffer.readLine()) != null) { // while not eof
				String inputArray[] = input.split(" "); 

				// if Username and Password match, flight object is displayed 
				if ((line).equals(inputArray[0]+" "+inputArray[1])) {
					firstName = inputArray[0]; 
					lastName = inputArray[1]; 
					type = inputArray[2]; 
					classF = inputArray[3]; 
					travelDestination = inputArray[4]; 
					departure = inputArray[5]; 
					adultPass = inputArray[6]; 
					childPass = inputArray [7]; 

					// Each flight element is displayed as a button
					flight = new JButton(firstName+"          "+lastName+"          "+type+"          "+classF+"          "+travelDestination+"          "+departure+"              "+adultPass+"         "+childPass);
					flight.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					flight.addActionListener(this);
					// adding each flight as a button 
					panel.add(flight);
					frame.getContentPane().add(panel);
					flight.addActionListener(new ActionListener() {
						/**
						 * This method uses ActionMouseListener, if flight button is clicked, there will be an option to cancel the flight 
						 */
						public void actionPerformed(ActionEvent e) {
							int result = JOptionPane.showConfirmDialog(frame, "Do you want to cancel the flight?");

							if (result  == JOptionPane.YES_OPTION) {
								// Calling method to remove line from txt file
								removeRecord("FlightHistory.txt", firstName+" "+lastName+" "+type+" "+classF+" "+travelDestination+" "+departure+" "+adultPass+" "+childPass);
								frame.dispose();
								try {
									// Class is reloaded to present the new flights after removal 
									Profile p = new Profile();
								} catch (MalformedURLException e1) {
									e1.printStackTrace();
								}


							} else if (result  == JOptionPane.NO_OPTION) {
								// If No button was pressed - nothing happens
							}
						}
					});
					frame.getContentPane().add(panel);    
				}



			}




			buffer.close();
			frame.getContentPane().setBackground(Color.white);
			frame.pack();
			frame.setSize(900,800);
			// Adding all components
			frame.add(back);
			frame.add(planee);
			frame.add(title);


		}



		catch(IOException err) {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE);
		}






	}
	/**
	 * This method finds the string to remove in the given txt file and deletes it
	 * @param filepath
	 * @param removeLine
	 */
	public static void removeRecord(String filepath, String removeLine)
	{
		//creates a new temporary file to copy info from old file
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);

		String currentLine;

		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			
			//reads from file path in parameter

			while((currentLine = br.readLine())!= null) {
				//copies lines from old file to new file EXCEPT the line you wish to remove
				if(!(currentLine.equals(removeLine))) {
					pw.println(currentLine);
				}

			}

			//close all the buffer readers and writers
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();

			//delete the old file and rename the new file as the old file
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
			
		}

		catch(Exception e) {
			//show error message
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE);
		}


	}


	/**
	 * This method uses ActionMouseListener to perform actions if a button is clicked 
	 */
	public void actionPerformed(ActionEvent e) {
		// If back button is clicked, user is redirected to the main menu 
		if(e.getSource() == back) {

			try {
				Welcome men2 = new Welcome();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}

			frame.dispose();

		}

	}

}
