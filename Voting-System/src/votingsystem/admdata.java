package votingsystem;

import java.awt.HeadlessException;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;
public class admdata extends JFrame implements ActionListener {
	private JButton adm;
	private JButton sdata;
	private JButton rem;
	private JButton btnExit;
	private JButton bk;
	public admdata(){
		getContentPane().setLayout(null);
		
		JLabel lblAdminDatabase = new JLabel("ADMIN DATABASE");
		lblAdminDatabase.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdminDatabase.setBounds(285, 28, 137, 14);
		getContentPane().add(lblAdminDatabase);
		
		adm = new JButton("ADD MEMBER");
		adm.setFont(new Font("Tahoma", Font.BOLD, 14));
		adm.setBounds(21, 103, 137, 23);
		getContentPane().add(adm);
		
		rem = new JButton("REMOVE MEMBER");
		rem.setFont(new Font("Tahoma", Font.BOLD, 14));
		rem.setBounds(543, 103, 159, 23);
		getContentPane().add(rem);
		
		sdata = new JButton("SHOW DATABASE\r\n");
		sdata.setFont(new Font("Tahoma", Font.BOLD, 14));
		sdata.setBounds(285, 192, 165, 23);
		getContentPane().add(sdata);
		
		btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(651, 237, 89, 23);
		getContentPane().add(btnExit);
		
		bk = new JButton("BACK");
		bk.setFont(new Font("Tahoma", Font.BOLD, 15));
		bk.setBounds(10, 237, 89, 23);
		getContentPane().add(bk);
		bk.addActionListener(this);
		btnExit.addActionListener(this);
		sdata.addActionListener(this);
		adm.addActionListener(this);
		rem.addActionListener(this);
		setVisible(true);
		setSize(756,300);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	

	public static void main(String[] args) {
		new admdata();
	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		Connection c=DBconnection.connect();
		if(ob==adm)
		{
			String id=JOptionPane.showInputDialog(this,"Enter ID");
			String i = id.toUpperCase();
			String n=JOptionPane.showInputDialog(this,"Enter NAME");
			String na=n.toUpperCase();
			int t=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter TOKEN"));
			try
			{
			Statement stm=c.createStatement();
			int r=stm.executeUpdate("INSERT INTO admdata VALUES ('"+i+"','"+na+"',"+t+");");
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ob==rem)
		{
			String d=JOptionPane.showInputDialog(this,"Enter Token");
			try
			{
			Statement stm=c.createStatement();
			int r=stm.executeUpdate("DELETE FROM admdata WHERE Token = "+d+"");
			if(r!=0)
				{
				JOptionPane.showMessageDialog(this, "Deleted");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "NOT DELETED");
				}
			}
			catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ob==sdata)
		{
			new Showdata();
		}
		else if(ob==btnExit)
		{
			System.exit(0);
		}
		else if(ob==bk)
		{
			new front();
		}
	}
}
