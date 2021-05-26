package gui;

import controller.*;
import database.DataAccessException;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class AddParking extends JFrame {

	private JPanel parkingInfoPane;
	private JTextField carRegNoTxtField;
	private JTextField carMakeTxtField;
	private JTextField carModelTxtField;
	private JComboBox carFuelTypeComboBox;
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtField;
	private JTextField phoneNoTxtField;
	private JTextField emailTxtField;
	private JTextField lotTxtField;
	private JTextField rowTxtField;
	private JTextField bayTxtField;
	private JTextField departureDateTxtField;
	private JTextField returnDateTxtField;
	private ParkingController parkCon;
	private String[] fuelTypeOptions = { "...", "Benzin", "Diesel", "Elektrisk" };
	private JCheckBox chargerChckBox;
	private JButton cancelBtn;

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

		initialize();
	}

	/**
	 * Initialize contents of the frame.
	 */
	private void initialize() {
		try {
			parkCon = new ParkingController();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parkCon.createParking();

		this.setTitle("Aalborg Lufthavns Parkeringsservice");
		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(AddParking.class.getResource("/asset/AALlogo-schema.png")));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 870, 475);
		parkingInfoPane = new JPanel();
		parkingInfoPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(parkingInfoPane);
		parkingInfoPane.setLayout(
				new MigLayout("", "[100px][102.00][][160.00,shrink 0][grow][][][27.00][][160.00,grow][160.00px]",
						"[][grow][][][][10.00][10.00][][][][][][][]"));

		JLabel carRegNoLbl = new JLabel("Nummerplade");
		carRegNoLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(carRegNoLbl, "cell 1 1,alignx right");

		carRegNoTxtField = new JTextField();
		carRegNoTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				findCar();
			}
		});
		carRegNoTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(carRegNoTxtField, "cell 3 1,growx");
		carRegNoTxtField.setColumns(10);

		JPanel panel = new JPanel();
		parkingInfoPane.add(panel, "cell 4 1,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));

		JLabel extraServiceAddOnLbl = new JLabel("Ekstra service");
		extraServiceAddOnLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(extraServiceAddOnLbl, "cell 5 1 3 1,alignx right,aligny baseline");

		chargerChckBox = new JCheckBox("Book ladestander");
		chargerChckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (chargerChckBox.isSelected()) {
					parkCon.addSelectedService(carMakeTxtField.getText());
				} else {
					parkCon.removeSelectedService();
				}
			}
		});
		chargerChckBox.setFont(new Font("Arial", Font.PLAIN, 18));
		chargerChckBox.setEnabled(false);
		parkingInfoPane.add(chargerChckBox, "cell 9 1");

		JLabel carMakeLbl = new JLabel("M\u00E6rke");
		carMakeLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(carMakeLbl, "cell 1 2,alignx right");

		carMakeTxtField = new JTextField();
		carMakeTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(carMakeTxtField, "cell 3 2,growx");
		carMakeTxtField.setColumns(10);

		JLabel lotLbl = new JLabel("Parkingsplads");
		lotLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(lotLbl, "cell 5 2 3 1,alignx right");

		lotTxtField = new JTextField();
		lotTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillInClientInformation();
			}
		});
		lotTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(lotTxtField, "cell 9 2,growx");
		lotTxtField.setColumns(10);

		JLabel carModelLbl = new JLabel("Model");
		carModelLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(carModelLbl, "cell 1 3,alignx right");

		carModelTxtField = new JTextField();
		carModelTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(carModelTxtField, "cell 3 3,growx");
		carModelTxtField.setColumns(10);

		JLabel rowLbl = new JLabel("R\u00E6kke");
		rowLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(rowLbl, "cell 5 3 3 1,alignx right");

		rowTxtField = new JTextField();
		rowTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillInClientInformation();
			}
		});
		rowTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(rowTxtField, "cell 9 3,growx");
		rowTxtField.setColumns(10);

		JLabel carFuelTypeLbl = new JLabel("Br\u00E6ndstoftype");
		carFuelTypeLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(carFuelTypeLbl, "cell 1 4,alignx right");

		carFuelTypeComboBox = new JComboBox(fuelTypeOptions);
		carFuelTypeComboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (carFuelTypeComboBox.getSelectedItem().equals("Elektrisk"))
					chargerChckBox.setEnabled(true);
			}
		});
		carFuelTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(carFuelTypeComboBox, "cell 3 4,growx");

		JLabel bayLbl = new JLabel("B\u00E5s");
		bayLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(bayLbl, "cell 5 4 3 1,alignx right");

		bayTxtField = new JTextField();
		bayTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillInClientInformation();
			}
		});
		bayTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(bayTxtField, "cell 9 4,growx");
		bayTxtField.setColumns(10);

		JPanel panel_1 = new JPanel();
		parkingInfoPane.add(panel_1, "cell 1 5 3 2,grow");
		panel_1.setLayout(new MigLayout("", "[]", "[]"));

		JLabel firstNameLbl = new JLabel("Fornavn");
		firstNameLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(firstNameLbl, "cell 1 7,alignx right");

		firstNameTxtField = new JTextField();
		firstNameTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillInClientInformation();
			}
		});
		firstNameTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(firstNameTxtField, "cell 3 7,growx");
		firstNameTxtField.setColumns(10);

		JLabel departureDateLbl = new JLabel("Afgang den");
		departureDateLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(departureDateLbl, "cell 5 7 3 1,alignx right");

		departureDateTxtField = new JTextField();
		departureDateTxtField.setText(LocalDate.now().toString());
		departureDateTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillInClientInformation();
			}
		});
		departureDateTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(departureDateTxtField, "cell 9 7,growx");
		departureDateTxtField.setColumns(10);

		JLabel lastNameLbl = new JLabel("Efternavn");
		lastNameLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(lastNameLbl, "cell 1 8,alignx right");

		lastNameTxtField = new JTextField();
		lastNameTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillInClientInformation();
			}
		});
		lastNameTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(lastNameTxtField, "cell 3 8,growx");
		lastNameTxtField.setColumns(10);

		JLabel returnDateLbl = new JLabel("Forventet ankomstdato den");
		returnDateLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(returnDateLbl, "cell 5 8 3 1,alignx right");

		returnDateTxtField = new JTextField();
		returnDateTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillInDates();
			}
		});
		returnDateTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(returnDateTxtField, "cell 9 8,growx");
		returnDateTxtField.setColumns(10);

		JLabel phoneNoLbl = new JLabel("Mobilnummer");
		phoneNoLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(phoneNoLbl, "cell 1 9,alignx right");

		phoneNoTxtField = new JTextField();
		phoneNoTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						fillInClientInformation();
					}
				});
			}
		});
		phoneNoTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(phoneNoTxtField, "cell 3 9,growx");
		phoneNoTxtField.setColumns(10);

		JLabel emailLbl = new JLabel("Mailadresse");
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(emailLbl, "cell 1 10,alignx right");

		emailTxtField = new JTextField();
		emailTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillInClientInformation();
			}
		});
		emailTxtField.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(emailTxtField, "cell 3 10,growx");
		emailTxtField.setColumns(10);

		JButton persistParkingBtn = new JButton("Opret parkering");
		persistParkingBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					if (saveParkingToDatabase() > 0) {
						int parkID = parkCon.getParkingID(carRegNoTxtField.getText());
						JOptionPane.showMessageDialog(carModelTxtField,
								"Din parkering er nu gemt\r\n" + "Din parkering har fået ID nummer: " + parkID);
						returnToFrontPage();
					} else {
						JOptionPane.showMessageDialog(carModelTxtField, "Din parkering er ikke blevet gemt");
					}
				} catch (DataAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		persistParkingBtn.setBackground(new Color(0, 255, 204));
		persistParkingBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(persistParkingBtn, "cell 9 13");

		cancelBtn = new JButton("Afbryd");
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				returnToFrontPage();
			}
		});
		cancelBtn.setBackground(new Color(255, 51, 0));
		cancelBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		parkingInfoPane.add(cancelBtn, "cell 10 13,growx");

//		debugData();

	}

	private void returnToFrontPage() {
		FrontPage frontPage = new FrontPage();
		frontPage.setVisible(true);
		setVisible(false);
		dispose();

	}

	private void findCar() {
		try {
			parkCon.addCar(carRegNoTxtField.getText());
			if (parkCon.getCar() == null) {
				JOptionPane.showMessageDialog(carRegNoTxtField,
						"Nummerplade ikke fundet\nVenligst indtast oplysningerne manuelt");
			} else {
				carMakeTxtField.setText(parkCon.getMake());
				carModelTxtField.setText(parkCon.getModel());
				carFuelTypeComboBox.setSelectedItem(parkCon.getFuelType());
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int saveParkingToDatabase() throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
//		try {
//			parkCon.addClientInformation(firstNameTxtField.getText(), lastNameTxtField.getText(),
//					phoneNoTxtField.getText(), emailTxtField.getText(), lotTxtField.getText(), rowTxtField.getText(),
//					bayTxtField.getText(), departureDateTxtField.getText(), returnDateTxtField.getText());
//		} catch (DataAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return parkCon.saveParking();
	}

	private void fillInClientInformation() {
		// TODO Auto-generated method stub
		try {
			parkCon.addClientInformation(firstNameTxtField.getText(), lastNameTxtField.getText(),
					phoneNoTxtField.getText(), emailTxtField.getText(), lotTxtField.getText(), rowTxtField.getText(),
					bayTxtField.getText(), departureDateTxtField.getText());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillInDates() {
		// TODO Auto-generated method stub
		parkCon.addDates(returnDateTxtField.getText());
	}

	private void debugData() {
		carRegNoTxtField.setText("BE12345");
		findCar();
		carMakeTxtField.setText(parkCon.getMake());
		carModelTxtField.setText(parkCon.getModel());
		carFuelTypeComboBox.setSelectedItem(parkCon.getFuelType());
		firstNameTxtField.setText("pølse");
		lastNameTxtField.setText("mix");
		phoneNoTxtField.setText("12345678");
		emailTxtField.setText("ja@nej.dk");
		lotTxtField.setText("P1");
		rowTxtField.setText("A");
		bayTxtField.setText("1");
		departureDateTxtField.setText("2020-12-12");
		returnDateTxtField.setText("2020-12-12");
	}

	public void reset() {
		carRegNoTxtField.setText("");
		carMakeTxtField.setText("");
		carModelTxtField.setText("");
		carFuelTypeComboBox.setSelectedItem("");
		firstNameTxtField.setText("");
		lastNameTxtField.setText("");
		phoneNoTxtField.setText("");
		emailTxtField.setText("");
		lotTxtField.setText("");
		rowTxtField.setText("");
		bayTxtField.setText("");
		departureDateTxtField.setText("");
		returnDateTxtField.setText("");
	}

	public String getCarMake() {
		return carMakeTxtField.getText();

	}

	public String getCarModel() {
		return carModelTxtField.getText();

	}

	public String getCarFuelType() {
		return (String) carFuelTypeComboBox.getSelectedItem();

	}

	public void cancelButtonClicked() throws AWTException {
		Robot robot = new Robot();
		cancelBtn.setVisible(true);
		carRegNoTxtField.setText("DI12345");
		findCar();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//Thread.sleep(5000);
				robot.mouseMove(cancelBtn.getX()+25, cancelBtn.getY()+25);
				//robot.delay(5000);
				//robot.mousePress(MouseEvent.MOUSE_PRESSED);
				//robot.mouseRelease(MouseEvent.MOUSE_RELEASED);
				robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

	}

});
	}
}
