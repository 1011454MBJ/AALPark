package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontPage extends JFrame {

	private JPanel frontPagePane;
	private JFrame frontPageFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage frame = new FrontPage();
					frame.frontPageFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrontPage() {
		initialize();
	}
	
	/**
	 * Initialize contents of the frame.
	 */
	private void initialize() {
		
		frontPageFrame = new JFrame();
		frontPageFrame.setTitle("Aalborg Lufthavns Parkeringsservice");
		frontPageFrame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(FrontPage.class.getResource("/asset/AALlogo-schema.png")));
		frontPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frontPageFrame.setBounds(100, 100, 870, 475);
		frontPagePane = new JPanel();
		frontPagePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frontPageFrame.setContentPane(frontPagePane);
		frontPagePane.setLayout(new MigLayout("", "[68.00][][][][][][grow][][][][][][][][][][][][][][][][][][][][]", "[grow][grow][][][][][][][][][][][][][][][][]"));
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		frontPagePane.add(backgroundPanel, "cell 0 0 4 18,grow");
		backgroundPanel.setLayout(new MigLayout("", "[125px,grow]", "[22.00px][23px][22px][23px][22px][23px][22px][][22px][][22px][][22px][][22px]"));
		
		JPanel topMenuPanel = new JPanel();
		backgroundPanel.add(topMenuPanel, "cell 0 0,grow");
		topMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton registerNewParkingBtn = new JButton("Registrer parkering");
		registerNewParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(registerNewParkingBtn, "cell 0 1");
		
		JPanel firstSplitMenuPanel = new JPanel();
		backgroundPanel.add(firstSplitMenuPanel, "cell 0 2,grow");
		firstSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton searchParkingBtn = new JButton("S\u00F8g parkering");
		searchParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(searchParkingBtn, "cell 0 3,growx");
		
		JPanel secondSplitMenuPanel = new JPanel();
		backgroundPanel.add(secondSplitMenuPanel, "cell 0 4,grow");
		secondSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton extendParkingBtn = new JButton("Forl\u00E6ng parkering");
		extendParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(extendParkingBtn, "cell 0 5,growx");
		
		JPanel thirdSplitMenuPanel = new JPanel();
		backgroundPanel.add(thirdSplitMenuPanel, "cell 0 6,grow");
		thirdSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton endParkingBtn = new JButton("Afslut parkering");
		endParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(endParkingBtn, "cell 0 7,growx");
		
		JPanel fourthSplitMenuPanel = new JPanel();
		backgroundPanel.add(fourthSplitMenuPanel, "cell 0 8,grow");
		fourthSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton makeNewIssueBtn = new JButton("Opret ny h\u00E6ndelse");
		makeNewIssueBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(makeNewIssueBtn, "cell 0 9,growx");
		
		JPanel fifthSplitMenuPanel = new JPanel();
		backgroundPanel.add(fifthSplitMenuPanel, "cell 0 10,grow");
		fifthSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton serviceBtn = new JButton("Service");
		serviceBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(serviceBtn, "cell 0 11,growx");
		
		JPanel sixthSplitMenuPanel = new JPanel();
		backgroundPanel.add(sixthSplitMenuPanel, "cell 0 12,grow");
		sixthSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton helpBtn = new JButton("Hj\u00E6lp");
		helpBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(helpBtn, "cell 0 13,growx,aligny top");
		
		JPanel bottomMenuPanel = new JPanel();
		backgroundPanel.add(bottomMenuPanel, "cell 0 14,grow");
		bottomMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		helpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel welcomePanel = new JPanel();
		frontPagePane.add(welcomePanel, "cell 6 1 18 6,grow");
		welcomePanel.setLayout(new MigLayout("", "[]", "[][][]"));
		
		JLabel frontPageGreetingLbl = new JLabel("Velkommen til Aalborg Lufthavns parkeringsservice");
		welcomePanel.add(frontPageGreetingLbl, "cell 0 0");
		frontPageGreetingLbl.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel frontPageSubtitleLbl = new JLabel("Venligst registrere din parkering her");
		frontPageSubtitleLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		welcomePanel.add(frontPageSubtitleLbl, "cell 0 2");
	}

}
