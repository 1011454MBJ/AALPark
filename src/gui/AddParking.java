package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AddParking extends JFrame {

	private JPanel contentPane;
	private JTextField carRegNoTxtField;
	private JTextField carMakeTxtField;
	private JTextField carModelTxtField;
	private JTextField carFuelTypeTxtField;
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtField;
	private JTextField phoneNoTxtField;
	private JTextField emailTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddParking frame = new AddParking();
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
	public AddParking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][160.00][][][][][][][][][][][][][][][][][][][][][][][][158.00][158px]", "[][][][][][][][][][][][][][]"));
		
		JLabel carRegNoLbl = new JLabel("Nummerplade");
		carRegNoLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carRegNoLbl, "cell 0 1,alignx right");
		
		carRegNoTxtField = new JTextField();
		carRegNoTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carRegNoTxtField, "cell 2 1,growx");
		carRegNoTxtField.setColumns(10);
		
		JLabel carMakeLbl = new JLabel("M\u00E6rke");
		carMakeLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carMakeLbl, "cell 0 2,alignx right");
		
		carMakeTxtField = new JTextField();
		carMakeTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carMakeTxtField, "cell 2 2,growx");
		carMakeTxtField.setColumns(10);
		
		JLabel carModelLbl = new JLabel("Model");
		carModelLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carModelLbl, "cell 0 3,alignx right");
		
		carModelTxtField = new JTextField();
		carModelTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carModelTxtField, "cell 2 3,growx");
		carModelTxtField.setColumns(10);
		
		JLabel carFuelTypeLbl = new JLabel("Br\u00E6ndstoftype");
		carFuelTypeLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carFuelTypeLbl, "cell 0 4,alignx right");
		
		carFuelTypeTxtField = new JTextField();
		carFuelTypeTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carFuelTypeTxtField, "cell 2 4,growx");
		carFuelTypeTxtField.setColumns(10);
		
		JLabel firstNameLbl = new JLabel("Fornavn");
		firstNameLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(firstNameLbl, "cell 0 7");
		
		firstNameTxtField = new JTextField();
		firstNameTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(firstNameTxtField, "cell 2 7,growx");
		firstNameTxtField.setColumns(10);
		
		JLabel lastNameLbl = new JLabel("Efternavn");
		lastNameLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(lastNameLbl, "cell 0 8");
		
		lastNameTxtField = new JTextField();
		lastNameTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(lastNameTxtField, "cell 2 8,growx");
		lastNameTxtField.setColumns(10);
		
		JLabel phoneNoLbl = new JLabel("Mobilnummer");
		phoneNoLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(phoneNoLbl, "cell 0 9");
		
		phoneNoTxtField = new JTextField();
		phoneNoTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(phoneNoTxtField, "cell 2 9,growx");
		phoneNoTxtField.setColumns(10);
		
		JLabel emailLbl = new JLabel("Mailadresse");
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(emailLbl, "cell 0 10");
		
		emailTxtField = new JTextField();
		emailTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(emailTxtField, "cell 2 10,growx");
		emailTxtField.setColumns(10);
		
		JButton persistParkingBtn = new JButton("Opret parkering");
		persistParkingBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(persistParkingBtn, "cell 26 13");
		
		JButton cancelBtn = new JButton("Afbryd");
		cancelBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(cancelBtn, "cell 27 13,growx");
	}

}
