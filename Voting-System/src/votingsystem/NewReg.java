package votingsystem;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;


public class NewReg extends JFrame implements ActionListener{
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JButton sub;
	private JButton ex;
	String p,cp;
	private JButton bk;
	private JButton ref;
	public NewReg(){
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(60, 52, 46, 14);
		getContentPane().add(lblName);
		
		tf1 = new JTextField();
		tf1.setBounds(268, 49, 86, 20);
		getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JLabel lblNewRegistration = new JLabel("NEW  REGISTRATION");
		lblNewRegistration.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewRegistration.setBounds(119, 11, 189, 14);
		getContentPane().add(lblNewRegistration);
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserId.setBounds(60, 99, 71, 14);
		getContentPane().add(lblUserId);
		
		tf2 = new JTextField();
		tf2.setBounds(268, 96, 86, 20);
		getContentPane().add(tf2);
		tf2.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(60, 136, 96, 14);
		getContentPane().add(lblPassword);
		
		tf3 = new JTextField();
		tf3.setBounds(268, 133, 86, 20);
		getContentPane().add(tf3);
		tf3.setColumns(10);
		
		JLabel lblCnfPassword = new JLabel("CNF PASSWORD");
		lblCnfPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCnfPassword.setBounds(60, 182, 124, 14);
		getContentPane().add(lblCnfPassword);
		
		tf4 = new JTextField();
		tf4.setBounds(268, 179, 86, 20);
		getContentPane().add(tf4);
		tf4.setColumns(10);
		
		sub = new JButton("SUBMIT");
		sub.setFont(new Font("Tahoma", Font.BOLD, 16));
		sub.setBounds(155, 207, 102, 23);
		sub.addActionListener(this);
		getContentPane().add(sub);
		
		ex = new JButton("EXIT");
		ex.setFont(new Font("Tahoma", Font.BOLD, 15));
		ex.setBounds(328, 237, 89, 23);
		getContentPane().add(ex);
		
		bk = new JButton("BACK");
		bk.setFont(new Font("Tahoma", Font.BOLD, 15));
		bk.setBounds(10, 239, 89, 23);
		getContentPane().add(bk);
		
		ref = new JButton("REFRESH");
		ref.setFont(new Font("Tahoma", Font.BOLD, 15));
		ref.setBounds(155, 241, 102, 23);
		getContentPane().add(ref);
		bk.addActionListener(this);
		ex.addActionListener(this);
		ref.addActionListener(this);
		setLocationRelativeTo(null);
		setSize(433,300);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NewReg();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob=e.getSource();
		if(ob== sub)
		{
			String Name=tf1.getText();
			String uid=tf2.getText();
		    p=(tf3.getText());
			cp=(tf4.getText());
			boolean n=p.equals(cp);
			if(n)
			{
			try
			{
			Connection c=DBconnection.connect();
			Statement stm=c.createStatement();
			
				int r=stm.executeUpdate("INSERT INTO voter values ('"+uid+"','"+cp+"','"+Name+"');");
			if(r!=0)
				{
				JOptionPane.showMessageDialog(this, "INSERTED");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "NOT INSERTED");
				}
			}
			catch (HeadlessException e1) {
				e1.printStackTrace();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			}
		else
		{
			JOptionPane.showMessageDialog(this, "please enter same password");
		}
}
		if(ob==ex)
		{
			System.exit(0);
		}
		if(ob==bk)
		{
			new front();
		} 
		if(ob==ref)
		{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
		}
	}
}
