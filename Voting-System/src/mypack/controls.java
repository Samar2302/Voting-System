package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class controls extends JFrame implements ActionListener{
	private JTextField gender;
	private JTextField radio;
	private JTextField textField_5;
	private JTextField textField;

	public controls() {
	getContentPane().setLayout(null);
	
	JRadioButton rdbtnMale = new JRadioButton("Male");
	rdbtnMale.setBounds(6, 55, 109, 23);
	getContentPane().add(rdbtnMale);
	
	JRadioButton rdbtnFemale = new JRadioButton("Female");
	rdbtnFemale.setBounds(6, 86, 109, 23);
	getContentPane().add(rdbtnFemale);
	
	JRadioButton rdbtnSecondary = new JRadioButton("Secondary");
	rdbtnSecondary.setBounds(6, 132, 109, 23);
	getContentPane().add(rdbtnSecondary);
	
	JRadioButton rdbtnSrSecondary = new JRadioButton("Sr. Secondary");
	rdbtnSrSecondary.setBounds(6, 158, 109, 23);
	getContentPane().add(rdbtnSrSecondary);
	
	JRadioButton rdbtnGraduate = new JRadioButton("Graduate");
	rdbtnGraduate.setBounds(6, 184, 109, 23);
	getContentPane().add(rdbtnGraduate);
	
	JCheckBox chckbxSleeping = new JCheckBox("Sleeping");
	chckbxSleeping.setBounds(6, 247, 97, 23);
	getContentPane().add(chckbxSleeping);
	
	JCheckBox chckbxSketching = new JCheckBox("Sketching");
	chckbxSketching.setBounds(6, 279, 97, 23);
	getContentPane().add(chckbxSketching);
	
	JCheckBox chckbxInstagram = new JCheckBox("Instagram");
	chckbxInstagram.setBounds(6, 305, 97, 23);
	getContentPane().add(chckbxInstagram);
	
	gender = new JTextField();
	gender.setBackground(Color.RED);
	gender.setEditable(false);
	gender.setBounds(176, 56, 132, 20);
	getContentPane().add(gender);
	gender.setColumns(10);
	
	radio = new JTextField();
	radio.setBackground(Color.RED);
	radio.setEditable(false);
	radio.setColumns(10);
	radio.setBounds(176, 133, 132, 20);
	getContentPane().add(radio);
	
	textField_5 = new JTextField();
	textField_5.setEditable(false);
	textField_5.setBackground(Color.RED);
	textField_5.setColumns(10);
	textField_5.setBounds(176, 248, 132, 20);
	getContentPane().add(textField_5);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select City", "Lucknow", "Delhi", "Chennai", "Vegas"}));
	comboBox.setBounds(6, 356, 97, 20);
	getContentPane().add(comboBox);
	
	textField = new JTextField();
	textField.setEditable(false);
	textField.setBackground(Color.RED);
	textField.setBounds(176, 356, 132, 20);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	JButton btnClose = new JButton("Close");
	btnClose.setBounds(300, 410, 89, 23);
	getContentPane().add(btnClose);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(controls.class.getResource("/images/demo pika.jpg")));
	lblNewLabel.setBounds(6, 11, 395, 422);
	getContentPane().add(lblNewLabel);
	
	JTextPane textPane = new JTextPane();
	textPane.setBounds(143, 89, 6, 20);
	getContentPane().add(textPane);
	setSize(427,483);
	setVisible(true);}

	public static void main(String[] args) {
		
new controls();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
