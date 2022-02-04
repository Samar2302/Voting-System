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


public class Voterlogin extends JDialog implements ActionListener {
	private JButton sub;
	private JPasswordField pf;
	private JTextField tf;
	public Voterlogin()
	{
		getContentPane().setLayout(null);
		
		JLabel lblWelcomeVoter = new JLabel("Welcome Voter");
		lblWelcomeVoter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeVoter.setBounds(88, 40, 176, 14);
		getContentPane().add(lblWelcomeVoter);
		
		JLabel lblVoterid = new JLabel("Voter_ID\r\n");
		lblVoterid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVoterid.setBounds(30, 81, 105, 14);
		getContentPane().add(lblVoterid);
		
		JLabel lblPassword = new JLabel("Password\t\r\n");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(30, 121, 105, 14);
		getContentPane().add(lblPassword);
		
		tf = new JTextField();
		tf.setBounds(230, 78, 86, 20);
		getContentPane().add(tf);
		tf.setColumns(10);
		
		pf = new JPasswordField();
		pf.setBounds(230, 118, 86, 20);
		getContentPane().add(pf);
		
		sub = new JButton("SUBMIT");
		sub.setFont(new Font("Tahoma", Font.BOLD, 16));
		sub.setBounds(121, 161, 114, 23);
		sub.addActionListener(this);
		getContentPane().add(sub);
		setSize(378,250);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	public static void main(String[] args) {
		new Voterlogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sub)
		{
			String user=tf.getText();
			String pass=new String(pf.getPassword());
			String st="Select * from Voter where Id=? and Password=?";
			Connection c=DBconnection.connect();
			try {
				PreparedStatement ps=c.prepareStatement(st);
				ps.setString(1, user); 
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					new Vote();
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
	}
}
