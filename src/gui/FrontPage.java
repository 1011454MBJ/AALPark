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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontPage extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[68.00][][][][][][][][][][][][][][][][][][][][][][][][][]", "[grow][][][][][][][][][][][][][][][][][]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLACK, 2, true));
		contentPane.add(panel, "cell 0 0 4 18,grow");
		panel.setLayout(new MigLayout("", "[125px,grow]", "[22.00px][23px][22px][23px][22px][23px][22px][][22px][][22px][][22px][][22px]"));
		
		JPanel topMenuPanel = new JPanel();
		panel.add(topMenuPanel, "cell 0 0,grow");
		topMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton registerNewParkingBtn = new JButton("Registrer parkering");
		registerNewParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(registerNewParkingBtn, "cell 0 1");
		
		JPanel firstSplitMenuPanel = new JPanel();
		panel.add(firstSplitMenuPanel, "cell 0 2,grow");
		firstSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton searchParkingBtn = new JButton("S\u00F8g parkering");
		searchParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(searchParkingBtn, "cell 0 3,growx");
		
		JPanel secondSplitMenuPanel = new JPanel();
		panel.add(secondSplitMenuPanel, "cell 0 4,grow");
		secondSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton extendParkingBtn = new JButton("Forl\u00E6ng parkering");
		extendParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(extendParkingBtn, "cell 0 5,growx");
		
		JPanel thirdSplitMenuPanel = new JPanel();
		panel.add(thirdSplitMenuPanel, "cell 0 6,grow");
		thirdSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton endParkingBtn = new JButton("Afslut parkering");
		endParkingBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(endParkingBtn, "cell 0 7,growx");
		
		JPanel fourthSplitMenuPanel = new JPanel();
		panel.add(fourthSplitMenuPanel, "cell 0 8,grow");
		fourthSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton makeNewIssueBtn = new JButton("Opret ny h\u00E6ndelse");
		makeNewIssueBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(makeNewIssueBtn, "cell 0 9,growx");
		
		JPanel fifthSplitMenuPanel = new JPanel();
		panel.add(fifthSplitMenuPanel, "cell 0 10,grow");
		fifthSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton serviceBtn = new JButton("Service");
		serviceBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(serviceBtn, "cell 0 11,growx");
		
		JPanel sixthSplitMenuPanel = new JPanel();
		panel.add(sixthSplitMenuPanel, "cell 0 12,grow");
		sixthSplitMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton helpBtn = new JButton("Hj\u00E6lp");
		helpBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(helpBtn, "cell 0 13,growx,aligny top");
		
		JPanel bottomMenuPanel = new JPanel();
		panel.add(bottomMenuPanel, "cell 0 14,grow");
		bottomMenuPanel.setLayout(new MigLayout("", "[]", "[]"));
		helpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel frontPageGreetingLbl = new JLabel("Velkommen til Aalborg Lufthavns parkeringsservice");
		frontPageGreetingLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(frontPageGreetingLbl, "cell 7 4 16 1,alignx left,aligny center");
	}

}
