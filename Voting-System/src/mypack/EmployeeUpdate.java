package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class EmployeeUpdate extends JDialog implements ActionListener{
	private JTextField tid;
	private JTextField tname;
	private JTextField tsalary;
	private JTextField tax;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton cancel;
	private JButton submit;
	private JComboBox tcity;
	private JRadioButton m;
	private JRadioButton f;
	int id;

	public EmployeeUpdate(int id) {
		this.id=id;
		getContentPane().setLayout(null);
		setModal(true);
		JLabel lblId = new JLabel("Name");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(26, 66, 63, 30);
		getContentPane().add(lblId);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(26, 117, 63, 30);
		getContentPane().add(lblGender);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(26, 173, 63, 30);
		getContentPane().add(lblCity);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalary.setBounds(26, 223, 63, 30);
		getContentPane().add(lblSalary);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTax.setBounds(26, 281, 63, 30);
		getContentPane().add(lblTax);
		
		JLabel label_4 = new JLabel("ID");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(26, 11, 63, 30);
		getContentPane().add(label_4);
		
		//tid = new JTextField(String.valueOf(id)); to convert into string
		tid=new JTextField(""+id);
		tid.setBackground(Color.WHITE);
		tid.setEditable(false);
		tid.setFont(new Font("Tahoma", Font.BOLD, 15));
		tid.setBounds(212, 18, 165, 20);
		getContentPane().add(tid);
		tid.setColumns(10);
		
		tname = new JTextField();
		tname.setBackground(Color.WHITE);
		tname.setEditable(false);

		tname.setFont(new Font("Tahoma", Font.BOLD, 15));
		tname.setColumns(10);
		tname.setBounds(212, 73, 165, 20);
		getContentPane().add(tname);
		
		tsalary = new JTextField();
		tsalary.setColumns(10);
		tsalary.setBounds(212, 230, 165, 20);
		getContentPane().add(tsalary);
		
		tax = new JTextField();
		tax.setColumns(10);
		tax.setBounds(212, 281, 165, 20);
		getContentPane().add(tax);
		
		m = new JRadioButton("Male");
		m.setForeground(Color.BLACK);
		m.setEnabled(false);
		buttonGroup.add(m);
		m.setFont(new Font("Tahoma", Font.BOLD, 15));
		m.setBounds(210, 123, 78, 23);
		getContentPane().add(m);
		
		f = new JRadioButton("Female");
		f.setForeground(Color.BLACK);
		f.setEnabled(false);
		buttonGroup.add(f);
		f.setFont(new Font("Tahoma", Font.BOLD, 15));
		f.setBounds(290, 121, 87, 23);
		getContentPane().add(f);
		
		tcity = new JComboBox();
		tcity.setModel(new DefaultComboBoxModel(new String[] {"Select City", "Lucknow", "Basti", "Gorakhpur", "Ghaziabad", "Noida", "Kanpur"}));
		tcity.setFont(new Font("Tahoma", Font.BOLD, 15));
		tcity.setBounds(212, 180, 165, 20);
		getContentPane().add(tcity);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.BOLD, 15));
		submit.setBounds(81, 360, 107, 30);
		getContentPane().add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancel.setBounds(240, 360, 107, 30);
		getContentPane().add(cancel);
		setSize(465,500);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		setLocationRelativeTo(null);
		setVisible(true);// to make window visible
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	Object ob=e.getSource();
	if(ob==cancel)
	{
		dispose();
	}
	else if(ob==submit)
	{
		
	}
		
	}
}
