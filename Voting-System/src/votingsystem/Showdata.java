package votingsystem;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.Color;


public class Showdata extends JFrame implements ActionListener {
	private JButton s;
	private JTable table;
	private JButton btnExit;
	private JButton b;
	public Showdata() {
		getContentPane().setLayout(null);
		
		JLabel lblMemberName = new JLabel("MEMBER NAME");
		lblMemberName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMemberName.setBounds(149, 11, 136, 14);
		getContentPane().add(lblMemberName);
		
		s = new JButton("SHOW\r\n");
		s.setFont(new Font("Tahoma", Font.BOLD, 16));
		s.setForeground(new Color(0, 0, 0));
		s.setBounds(160, 227, 89, 23);
		getContentPane().add(s);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 393, 119);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(333, 229, 89, 23);
		getContentPane().add(btnExit);
		
		b = new JButton("BACK");
		b.setFont(new Font("Tahoma", Font.BOLD, 14));
		b.setBounds(10, 229, 89, 23);
		getContentPane().add(b);
		b.addActionListener(this);
		btnExit.addActionListener(this);
		s.addActionListener(this);
		setSize(448,300);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	public static void main(String[] args) {
new Showdata();

}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==s)
		{
		//DefaultTableModel obj=(DefaultTableModel)table.getModel();
        
		try
		{
			Connection c=DBconnection.connect();
			Statement stm=c.createStatement();
			ResultSet rs=stm.executeQuery("select * from admdata ;");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			/*while(rs.next())
			{
				String mid=rs.getString("MembID");
				String mn=rs.getString("MembName");
				//obj.addRow(new Object[]{mid,mn});
			}*/
		}
		catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}
		if(ob==btnExit)
		{
			System.exit(0);
		}
		if(ob==b)
		{
			new admdata();
		}
	}	
}
