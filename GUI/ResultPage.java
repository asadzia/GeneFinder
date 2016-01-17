/**
 * The GUI to display the Results.
 * @author Asad zia
 *@Version 1.0
 */

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultPage {
	
	private String result;
	private JFrame mainframe;
	
	/**
	 * The constructor
	 * @param text
	 */
	public ResultPage(String text) {
		setResult(GeneProcessor.CheckDNA(text));
		prepareGUI();
	}
	
	/**
	 * The main GUI setup method
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
		background.setLayout(new GridLayout(3, 1));
		
		JLabel Head = new JLabel("", JLabel.CENTER);
		Head.setText("<html>"
				+ "<div style=\"line-height: 200px; margin: auto; margin-top: -100px; position: absolute;  font-size: 100px; left: 120px; font-weight: 600; letter-spacing: .2em; line-height: 1.1em;text-align:center; color: White;  font-family: Sans-serif, Hoefler Text, Georgia, 'Times New Roman'; font-size: 150%;\">"
				+ "RESULT" + ":"
				+ "</div>"
				+ "<br><br><br>"
				+ "<div  style=\"line-height: 200px; margin: auto; margin-top: -100px; position: absolute;  font-size: 100px; left: 120px; font-weight: normal; letter-spacing: .2em; line-height: 1.1em;text-align:center; color: White; font-family: Sans-serif, Hoefler Text, Georgia, 'Times New Roman'; font-size: 120%; \">"
				+ result
				+ "</div>"
				+ "</html>");
		
		background.add(Head);
		
		mainframe.setVisible(true);
	}
	
	/**
	 * The getter method for result
	 * @return result
	 */
	public String getResult() {
		return result;
	}
	
	/**
	 * The setter method
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
}