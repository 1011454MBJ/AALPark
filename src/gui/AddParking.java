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
import javax.swing.JComboBox;
import java.awt.Color;

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
	private JTextField parkIDTxtField;
	private JTextField lotTxtField;
	private JTextField rowTxtField;
	private JTextField bayTxtField;
	private JTextField departureDateTxtField;
	private JTextField returnDateTxtField;

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
		contentPane.setLayout(new MigLayout("", "[100px][102.00][][160.00,shrink 0][grow][][][27.00][][160.00,grow][160.00px]", "[][grow][][][][10.00][10.00][][][][][][][]"));
		
		JLabel carRegNoLbl = new JLabel("Nummerplade");
		carRegNoLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carRegNoLbl, "cell 1 1,alignx right");
		
		carRegNoTxtField = new JTextField();
		carRegNoTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carRegNoTxtField, "cell 3 1,growx");
		carRegNoTxtField.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 4 1,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel parkIDLbl = new JLabel("ParkeringsID");
		parkIDLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(parkIDLbl, "cell 5 1 3 1,alignx right,aligny baseline");
		
		parkIDTxtField = new JTextField();
		parkIDTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(parkIDTxtField, "cell 9 1,growx");
		parkIDTxtField.setColumns(10);
		
		JLabel carMakeLbl = new JLabel("M\u00E6rke");
		carMakeLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carMakeLbl, "cell 1 2,alignx right");
		
		carMakeTxtField = new JTextField();
		carMakeTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carMakeTxtField, "cell 3 2,growx");
		carMakeTxtField.setColumns(10);
		
		JLabel lotLbl = new JLabel("Parkingsplads");
		lotLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(lotLbl, "cell 5 2 3 1,alignx right");
		
		lotTxtField = new JTextField();
		lotTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(lotTxtField, "cell 9 2,growx");
		lotTxtField.setColumns(10);
		
		JLabel carModelLbl = new JLabel("Model");
		carModelLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carModelLbl, "cell 1 3,alignx right");
		
		carModelTxtField = new JTextField();
		carModelTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carModelTxtField, "cell 3 3,growx");
		carModelTxtField.setColumns(10);
		
		JLabel rowLbl = new JLabel("R\u00E6kke");
		rowLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(rowLbl, "cell 5 3 3 1,alignx right");
		
		rowTxtField = new JTextField();
		rowTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(rowTxtField, "cell 9 3,growx");
		rowTxtField.setColumns(10);
		
		JLabel carFuelTypeLbl = new JLabel("Br\u00E6ndstoftype");
		carFuelTypeLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carFuelTypeLbl, "cell 1 4,alignx right");
		
		carFuelTypeTxtField = new JTextField();
		carFuelTypeTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carFuelTypeTxtField, "cell 3 4,growx");
		carFuelTypeTxtField.setColumns(10);
		
		JLabel bayLbl = new JLabel("B\u00E5s");
		bayLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(bayLbl, "cell 5 4 3 1,alignx right");
		
		bayTxtField = new JTextField();
		bayTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(bayTxtField, "cell 9 4,growx");
		bayTxtField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 1 5 3 2,grow");
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel firstNameLbl = new JLabel("Fornavn");
		firstNameLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(firstNameLbl, "cell 1 7,alignx right");
		
		firstNameTxtField = new JTextField();
		firstNameTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(firstNameTxtField, "cell 3 7,growx");
		firstNameTxtField.setColumns(10);
		
		JLabel departureDateLbl = new JLabel("Afgang den");
		departureDateLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(departureDateLbl, "cell 5 7 3 1,alignx right");
		
		departureDateTxtField = new JTextField();
		departureDateTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(departureDateTxtField, "cell 9 7,growx");
		departureDateTxtField.setColumns(10);
		
		JLabel lastNameLbl = new JLabel("Efternavn");
		lastNameLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(lastNameLbl, "cell 1 8,alignx right");
		
		lastNameTxtField = new JTextField();
		lastNameTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(lastNameTxtField, "cell 3 8,growx");
		lastNameTxtField.setColumns(10);
		
		JLabel returnDateLbl = new JLabel("Forventet ankomstdato den");
		returnDateLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(returnDateLbl, "cell 5 8 3 1,alignx right");
		
		returnDateTxtField = new JTextField();
		returnDateTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(returnDateTxtField, "cell 9 8,growx");
		returnDateTxtField.setColumns(10);
		
		JLabel phoneNoLbl = new JLabel("Mobilnummer");
		phoneNoLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(phoneNoLbl, "cell 1 9,alignx right");
		
		phoneNoTxtField = new JTextField();
		phoneNoTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(phoneNoTxtField, "cell 3 9,growx");
		phoneNoTxtField.setColumns(10);
		
		JLabel emailLbl = new JLabel("Mailadresse");
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(emailLbl, "cell 1 10,alignx right");
		
		emailTxtField = new JTextField();
		emailTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(emailTxtField, "cell 3 10,growx");
		emailTxtField.setColumns(10);
		
		JButton persistParkingBtn = new JButton("Opret parkering");
		persistParkingBtn.setBackground(new Color(0, 255, 204));
		persistParkingBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(persistParkingBtn, "cell 9 13");
		
		JButton cancelBtn = new JButton("Afbryd");
		cancelBtn.setBackground(new Color(255, 51, 0));
		cancelBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(cancelBtn, "cell 10 13,growx");
	}

}
