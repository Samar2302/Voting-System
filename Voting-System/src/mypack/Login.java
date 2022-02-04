package mypack;

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
import java.sql.SQLException;
import java.util.logging.LoggingPermission;


public class Login extends JDialog implements ActionListener
{
	private JTextField tf;
	private JPasswordField p;
	private JButton submit;

	public Login()
	{
		setResizable(false);
		getContentPane().setBackground(new Color(0, 255, 0));
		setTitle("Login Window");
		getContentPane().setLayout(null);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(0, 128, 0));
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(22, 44, 100, 26);
		getContentPane().add(lblUserName);

		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(26, 102, 74, 26);
		getContentPane().add(lblNewLabel);

		tf = new JTextField();
		tf.setBounds(141, 49, 145, 20);
		getContentPane().add(tf);
		tf.setColumns(10);

		p = new JPasswordField();
		p.setBounds(141, 107, 145, 20);
		getContentPane().add(p);

		submit = new JButton("LOGIN");
		submit.addActionListener(this);
		submit.setMnemonic('L');
		submit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		submit.setBounds(99, 156, 100, 26);
		getContentPane().add(submit);
		setSize(350,246);
		getRootPane().setDefaultButton(submit);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args)
	{
		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit)
		{
			String user=tf.getText();
			String pass=new String(p.getPassword());
			String st="Select * from login where username=? and password=?";//"?" are known as place holders
			Connection c=DBConnection.connect();
			try {
				PreparedStatement ps=c.prepareStatement(st);
				ps.setString(1, user);
				ps.setString(2, pass);//setdatatype(int,datatype)
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					new Home();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Invalid");
					p.setText("");
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
/*create a class
 * main
 * const
 * container(extends)
 * implements(listener)
 * method
 * const
 * setLayout(null)
 * setSize()
 * setVisible(true)
 */
