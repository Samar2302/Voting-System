package votingsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*; 

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;



import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.logging.LoggingPermission;
import java.awt.BorderLayout;


public class Adminlogin extends JDialog implements ActionListener {
	private JTextField tf;
	private JPasswordField pf;
	private JButton Sub;
	public Adminlogin(){
		getContentPane().setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeAdmin.setBounds(108, 25, 127, 24);
		getContentPane().add(lblWelcomeAdmin);
		
		JLabel lblNewLabel = new JLabel("ADMIN ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(65, 84, 79, 24);
		getContentPane().add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(239, 86, 86, 20);
		getContentPane().add(tf);
		tf.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(65, 144, 86, 14);
		getContentPane().add(lblPassword);
		
		pf = new JPasswordField();
		pf.setBounds(239, 141, 86, 20);
		getContentPane().add(pf);
		
		Sub = new JButton("SUBMIT");
		Sub.setFont(new Font("Tahoma", Font.BOLD, 14));
		Sub.setBounds(138, 193, 97, 23);
		Sub.addActionListener(this);
		getContentPane().add(Sub);
		setResizable(true);
	setLocationRelativeTo(null);
	setVisible(true);
	setSize(356,256);
	setResizable(false);
	}



	public static void main(String[] args) {
		new Adminlogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Sub)
		{
			String user=tf.getText();
			String pass=new String(pf.getPassword());
			String st="Select * from admin where idadmin=? and Password=?";
			Connection c=DBconnection.connect();
			try {
				PreparedStatement ps=c.prepareStatement(st);
				ps.setString(1, user); 
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					new admdata();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Invalid");
					pf.setText("");
					tf.setText("");
					tf.requestFocusInWindow();
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
	}
	}}
