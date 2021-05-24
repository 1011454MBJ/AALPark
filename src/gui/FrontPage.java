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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
					frame.setVisible(true);
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
		
		//frontPageFrame = new JFrame();
		setTitle("Aalborg Lufthavns Parkeringsservice");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FrontPage.class.getResource("/asset/AALlogo-schema.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 475);
		frontPagePane = new JPanel();
		frontPagePane.setBackground(new Color(255, 255, 255));
		frontPagePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frontPagePane);
		frontPagePane.setLayout(new MigLayout("", "[68.00][][][][][][grow][][][][][][][][][][][][][][][][][][][][]", "[grow][grow][][][][][][][][][][][][][][][][]"));
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setForeground(new Color(0, 0, 102));
		backgroundPanel.setBackground(new Color(255, 255, 255));
		backgroundPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
		frontPagePane.add(backgroundPanel, "cell 0 0 4 18,grow");
		backgroundPanel.setLayout(new MigLayout("", "[125px,grow]", "[85.00px,grow][23px][2px][23px][2px][23px][2px][23px][2px][23px][2px][23px][2px][23px][2px]"));
		
		JPanel topMenuPanel = new JPanel();
		topMenuPanel.setBackground(new Color(255, 255, 255));
		backgroundPanel.add(topMenuPanel, "cell 0 0,grow");
		topMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton registerNewParkingBtn = new JButton("Registrer parkering");
		registerNewParkingBtn.setForeground(new Color(0, 0, 102));
		registerNewParkingBtn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				//showNewParkingDialog();
				showNewAddParking();
			}
		});
		
		registerNewParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(registerNewParkingBtn, "cell 0 1");
		
		JButton searchParkingBtn = new JButton("S\u00F8g parkering");
		searchParkingBtn.setForeground(new Color(0, 0, 102));
		searchParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(searchParkingBtn, "cell 0 3,growx");
		
		JButton extendParkingBtn = new JButton("Forl\u00E6ng parkering");
		extendParkingBtn.setForeground(new Color(0, 0, 102));
		extendParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(extendParkingBtn, "cell 0 5,growx");
		
		JButton endParkingBtn = new JButton("Afslut parkering");
		endParkingBtn.setForeground(new Color(0, 0, 102));
		endParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(endParkingBtn, "cell 0 7,growx");
		
		JButton makeNewIssueBtn = new JButton("Opret ny h\u00E6ndelse");
		makeNewIssueBtn.setForeground(new Color(0, 0, 102));
		makeNewIssueBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(makeNewIssueBtn, "cell 0 9,growx");
		
		JButton serviceBtn = new JButton("Service");
		serviceBtn.setForeground(new Color(0, 0, 102));
		serviceBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(serviceBtn, "cell 0 11,growx");
		
		JButton helpBtn = new JButton("Hj\u00E6lp");
		helpBtn.setForeground(new Color(0, 0, 102));
		helpBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		backgroundPanel.add(helpBtn, "cell 0 13,growx,aligny top");
		
		JPanel bottomMenuPanel = new JPanel();
		bottomMenuPanel.setBackground(new Color(255, 255, 255));
		backgroundPanel.add(bottomMenuPanel, "cell 0 14,grow");
		bottomMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
				
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(new Color(255, 255, 255));
		frontPagePane.add(welcomePanel, "cell 6 1 18 6,grow");
		welcomePanel.setLayout(new MigLayout("", "[]", "[][][]"));
		
		JLabel frontPageGreetingLbl = new JLabel("Velkommen til Aalborg Lufthavns parkeringsservice");
		frontPageGreetingLbl.setForeground(new Color(0, 0, 102));
		welcomePanel.add(frontPageGreetingLbl, "cell 0 0");
		frontPageGreetingLbl.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel frontPageSubtitleLbl = new JLabel("Venligst registrer din parkering her");
		frontPageSubtitleLbl.setForeground(new Color(0, 0, 102));
		frontPageSubtitleLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		welcomePanel.add(frontPageSubtitleLbl, "cell 0 2");
	}
	

	private void showNewParkingDialog() {
		NewParkingDialog newParkingDialog = new NewParkingDialog();
		newParkingDialog.setVisible(true);
	}
	

	private void showNewAddParking() {
		AddParking addParking = new AddParking();
		addParking.setVisible(true);
		setVisible(false);
		dispose();
		
	}

}
