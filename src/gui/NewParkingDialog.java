package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;

public class NewParkingDialog extends JDialog {

	private final JPanel newParkingPlateSearch = new JPanel();
	private JTextField registrationNoInputField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewParkingDialog dialog = new NewParkingDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewParkingDialog() {
		initialize();
	}
	
	private void initialize() {
		setTitle("Aalborg Lufthavns Parkeringsservice");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(NewParkingDialog.class.getResource("/asset/AALlogo-schema.png")));
		setBounds(100, 100, 440, 250);
		getContentPane().setLayout(new BorderLayout());
		newParkingPlateSearch.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(newParkingPlateSearch, BorderLayout.CENTER);
		newParkingPlateSearch.setLayout(new MigLayout("", "[42.00][166.00][][][][72.00px][grow][]", "[grow][grow][][][][][][grow]"));
		{
			JPanel dialogSpacerPanelTop = new JPanel();
			newParkingPlateSearch.add(dialogSpacerPanelTop, "cell 1 1,grow");
			dialogSpacerPanelTop.setLayout(new MigLayout("", "[]", "[]"));
		}
		{
			JPanel dialogSpacerPanelRight = new JPanel();
			newParkingPlateSearch.add(dialogSpacerPanelRight, "cell 6 1 1 7,grow");
			dialogSpacerPanelRight.setLayout(new MigLayout("", "[]", "[]"));
		}
		{
			JLabel plateTxtLbl = new JLabel("Hvad er din nummerplade?");
			plateTxtLbl.setFont(new Font("Arial", Font.PLAIN, 18));
			newParkingPlateSearch.add(plateTxtLbl, "cell 1 2");
		}
		{
			registrationNoInputField = new JTextField();
			registrationNoInputField.setFont(new Font("Arial", Font.PLAIN, 18));
			newParkingPlateSearch.add(registrationNoInputField, "cell 2 2 4 1,growx");
			registrationNoInputField.setColumns(10);
		}
		{
			JCheckBox foreignCarChckBx = new JCheckBox("Min bil er ikke dansk indregistreret");
			foreignCarChckBx.setFont(new Font("Arial", Font.PLAIN, 18));
			newParkingPlateSearch.add(foreignCarChckBx, "cell 1 4 5 1");
		}
		{
			JPanel dialogSpacerPanelBottom = new JPanel();
			newParkingPlateSearch.add(dialogSpacerPanelBottom, "cell 1 6,grow");
			dialogSpacerPanelBottom.setLayout(new MigLayout("", "[]", "[]"));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton continueBtn = new JButton("Forts\u00E6t");
				continueBtn.setFont(new Font("Arial", Font.PLAIN, 18));
				continueBtn.setActionCommand("OK");
				buttonPane.add(continueBtn);
				getRootPane().setDefaultButton(continueBtn);
			}
			{
				JButton cancelBtn = new JButton("Afbryd");
				cancelBtn.setFont(new Font("Arial", Font.PLAIN, 18));
				cancelBtn.setActionCommand("Cancel");
				buttonPane.add(cancelBtn);
			}
		}
	}

}
