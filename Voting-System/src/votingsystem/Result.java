package votingsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mypack.DBConnection;

import java.sql.*;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Result extends JFrame implements ActionListener {
int i,id;
String g;
Connection c=DBconnection.connect();
private JButton sh;
private JButton ex;
private JButton b;
	public Result() {
		getContentPane().setLayout(null);
		
		sh = new JButton("SHOW");
		sh.setFont(new Font("Tahoma", Font.BOLD, 15));
		sh.setBounds(96, 121, 89, 23);
		getContentPane().add(sh);
		
		JLabel lblResult = new JLabel("RESULT ");
		lblResult.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 18));
		lblResult.setBounds(99, 49, 156, 30);
		getContentPane().add(lblResult);
		
		ex = new JButton("EXIT");
		ex.setFont(new Font("Tahoma", Font.BOLD, 15));
		ex.setBounds(205, 163, 89, 23);
		getContentPane().add(ex);
		
		b = new JButton("BACK");
		b.setFont(new Font("Tahoma", Font.BOLD, 14));
		b.setBounds(0, 165, 89, 23);
		getContentPane().add(b);
		b.addActionListener(this);
		ex.addActionListener(this);
		sh.addActionListener(this);
		setVisible(true);
		setSize(300,215);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		new Result();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==sh)
		{
		String st="select max(Nvote) from Vote ";
		try
		{
		PreparedStatement ps=c.prepareStatement(st);
		ResultSet rs=ps.executeQuery();
		rs.next();
		i=rs.getInt(1);
		//JOptionPane.showMessageDialog(null, ""+i);
		
		}
		catch(SQLException se)
		{
			
			se.printStackTrace();
		}
		String s="select Token from Vote where Nvote="+i+"";
		try
		{
		PreparedStatement ps=c.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		rs.next();
		id=rs.getInt(1);
		//JOptionPane.showMessageDialog(null, ""+id);
		
		}
		catch(SQLException se)
		{
			
			se.printStackTrace();
		}
		
		String t="select Name from admdata where Token="+id+"";
		try
		{
		PreparedStatement ps=c.prepareStatement(t);
		ResultSet rs=ps.executeQuery();
		rs.next();
		g=rs.getString(1);
		JOptionPane.showMessageDialog(null, "CONGRATULATIONS "+g+" FOR WINNING");
		
		}
		catch(SQLException se)
		{
			
			se.printStackTrace();
		}
		}
		if(ob==ex)
		{
			int y=JOptionPane.showConfirmDialog(null,"Sure To Exit");
			if(y==0)
				System.exit(0);
		}
		if(ob==b)
		{
			new Vote();
		}
	}
}
