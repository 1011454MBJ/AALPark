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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		contentPane.setLayout(new MigLayout("", "[][][grow][][][][][][][][][][][][][][][][][][][][][][][][158.00][158px]", "[][][][][][][][][][][][][][]"));
		
		JLabel regNoLbl = new JLabel("Nummerplade");
		regNoLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(regNoLbl, "cell 0 1");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 1,growx");
		textField.setColumns(10);
		
		JLabel carMakeLbl = new JLabel("M\u00E6rke");
		carMakeLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carMakeLbl, "cell 0 2");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 2 2,growx");
		textField_1.setColumns(10);
		
		JLabel carModelLbl = new JLabel("Model");
		carModelLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carModelLbl, "cell 0 3");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 2 3,growx");
		textField_2.setColumns(10);
		
		JLabel carFuelTypeLbl = new JLabel("Br\u00E6ndstoftype");
		carFuelTypeLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(carFuelTypeLbl, "cell 0 4");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 2 4,growx");
		textField_3.setColumns(10);
		
		JButton persistParkingBtn = new JButton("Opret parkering");
		persistParkingBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(persistParkingBtn, "cell 26 13");
		
		JButton cancelBtn = new JButton("Afbryd");
		cancelBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(cancelBtn, "cell 27 13,growx");
	}

}
