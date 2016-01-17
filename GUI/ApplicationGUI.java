/**
 * The class which defines the GUI interface.
 * @author Asad Zia
 * @Version 1.0
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ApplicationGUI {
	
	private JFrame mainframe;
	private JLabel frontHeader;
	private JLabel frontFooter;
	private JButton EnterButton;
	private JTextField GeneInput;
	
	/**
	 * The constructor
	 */
	public ApplicationGUI()
	{
		prepareGUI();
		ApplicationStartup();
	}
	
	/**
	 * The main GUI method
	 */
	public void prepareGUI()
	{
		/* setting up the JFrame */
		mainframe = new JFrame("Gene Finder");
		mainframe.setSize(800, 700);
		mainframe.setLocationRelativeTo(null);
		
		mainframe.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		});
		
		/* adding a background image by using JLabel */
		JLabel background = new JLabel(new ImageIcon(ApplicationGUI.class.getResource("Background.jpg")));
		mainframe.add(background);
		background.setLayout(new GridLayout(4, 1));
		
		/* initializing the JLabel elements */
		frontHeader = new JLabel("", JLabel.CENTER);
		frontFooter = new JLabel("", JLabel.CENTER);
		
	    
		/* defining the properties of the JPanel*/
	    GeneInput = new JTextField(20);
	    Font font = new Font("Verdana", Font.BOLD, 60);
	    GeneInput.setFont(font);
	    
	    /* setting up the enter button on the front screen */
		ImageIcon icon = new ImageIcon(ApplicationGUI.class.getResource("Enter_icon.jpg"));
		EnterButton = new JButton(icon);
		EnterButton.setBackground(Color.black);
		EnterButton.setOpaque(false);
		EnterButton.setContentAreaFilled(false);
		EnterButton.setBorderPainted(false);
		EnterButton.setFocusPainted(false);
		EnterButton.setActionCommand("Enter");
	
	    
		/* adding the components to the background */
		background.add(frontHeader);
		background.add(GeneInput);
		background.add(EnterButton);
		background.add(frontFooter);
		
		mainframe.setVisible(true);
	}
	
	/**
	 * The method for giving functionality to the GUI.
	 */
	public void ApplicationStartup ()
	{
		/* USe HTML tags to set and arrange the text */
		frontHeader.setText("<html>"
				+ "<div style=\"line-height: 200px; margin: auto; margin-top: -100px; position: absolute;  font-size: 100px; left: 120px; font-weight: 600; letter-spacing: .2em; line-height: 1.1em;text-align:center; color: White;  font-family: Sans-serif, Hoefler Text, Georgia, 'Times New Roman'; font-size: 150%;\">"
				+ "A GENE FINDING APPLICATION"
				+ "</div>"
				+ "<br>"
				+ "<div  style=\"line-height: 200px; margin: auto; margin-top: -100px; position: absolute;  font-size: 100px; left: 120px; font-weight: normal; letter-spacing: .2em; line-height: 1.1em;text-align:center; color: White; font-family: Sans-serif, Hoefler Text, Georgia, 'Times New Roman'; font-size: 120%; \">"
				+ "Enter a DNA Sequence to search for a Gene."
				+ "</div>"
				+ "</html>");
		
		frontFooter.setText("<html>"
				+ "<div style=\"line-height: 200px; margin: auto; margin-top: -100px; position: absolute;  font-size: 80px; left: 120px; font-weight: 600; letter-spacing: .2em; line-height: 1.6em;text-align:center; color: Black;  font-family: Sans-serif; font-size: 120%;\">"
				+ "Created By: AZ"
				+ "</div></html>");
		
		
	
		/* Add event for the Enter button */
		EnterButton.addActionListener(new ActionListener ()
		{
			public void actionPerformed( ActionEvent e)
			{
					mainframe.dispose();
					new ResultPage(GeneInput.getText());
				}
		});
		
		mainframe.setVisible(true);
	}	
	
	/**
	 * The main method
	 * @param args
	 */
	public static void main (String args [])
	{
		@SuppressWarnings("unused")
		ApplicationGUI myApp = new ApplicationGUI();
	}
}
