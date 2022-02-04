package votingsystem;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;

import net.proteanit.sql.DbUtils;
public class Vote extends JFrame implements ActionListener{
	
	private JRadioButton btn1;
	private JRadioButton btn2;
	private JRadioButton btn3;
	private JRadioButton btn4;
	
	private final ButtonGroup bg = new ButtonGroup();
	private JButton ad;
	private JList li;
	private JButton VSub;
	private JButton ref;
	int i = 0,j=0,k=0,l=0;
	int a,b,d,p;
	Connection c=DBconnection.connect();
	private JButton res;
	private JLabel lblListOfCandidates;
	private JButton ex;
	public Vote()
	{
		getContentPane().setLayout(null);
		
		JLabel lblWelcomeVoterPlease = new JLabel("Welcome Voter please Vote");
		lblWelcomeVoterPlease.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeVoterPlease.setBounds(52, 33, 214, 22);
		getContentPane().add(lblWelcomeVoterPlease);
		
		btn1 = new JRadioButton("1");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		bg.add(btn1);
		btn1.setMnemonic('L');
		btn1.setBounds(99, 106, 109, 23);
		getContentPane().add(btn1);
		
		btn2 = new JRadioButton("2");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2.setMnemonic('L');
		bg.add(btn2);
		btn2.setBounds(99, 144, 109, 23);
		getContentPane().add(btn2);
		
		ad = new JButton("ADD");
		ad.setFont(new Font("Tahoma", Font.BOLD, 15));
		ad.setBounds(10, 293, 89, 23);
		getContentPane().add(ad);
		
		VSub = new JButton("SUBMIT");
		VSub.setFont(new Font("Tahoma", Font.BOLD, 14));
		VSub.setBounds(52, 259, 99, 23);
		getContentPane().add(VSub);
		DefaultListModel<String> l=new DefaultListModel<>();
		
		try
		{
		Statement stm=c.createStatement();
		ResultSet rs=stm.executeQuery("select Name from admdata ;");
		
		while(rs.next())
		{
			String mn=rs.getString("Name");
			l.addElement(mn);
		}
		li = new JList(l);
		}
		catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//li=new JList(l);
		li.setBounds(218, 92, 48, 75);
		getContentPane().add(li);
		
		ref = new JButton("BACK");
		ref.setFont(new Font("Tahoma", Font.BOLD, 14));
		ref.setBounds(204, 295, 99, 23);
		getContentPane().add(ref);
		
		res = new JButton("RESULT");
		res.setFont(new Font("Tahoma", Font.BOLD, 15));
		res.setBounds(176, 259, 99, 23);
		getContentPane().add(res);
		
		lblListOfCandidates = new JLabel("List of Candidates");
		lblListOfCandidates.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListOfCandidates.setBounds(186, 66, 127, 14);
		getContentPane().add(lblListOfCandidates);
		
		ex = new JButton("EXIT");
		ex.setFont(new Font("Tahoma", Font.BOLD, 14));
		ex.setBounds(105, 295, 89, 23);
		getContentPane().add(ex);
		ex.addActionListener(this);
		ad.addActionListener(this);
		VSub.addActionListener(this);
		ref.addActionListener(this);
		res.addActionListener(this);
	    setLocationRelativeTo(this);
		setSize(319,356);
		setResizable(false);
		setVisible(true);
	}
	

	public static void main(String[] args) {
new Vote();

}

	@Override
	public void actionPerformed(ActionEvent r) {
	Object ob=r.getSource();
	
	
		if(ob==ad)
	{
			String n = JOptionPane.showInputDialog(this,"enter no. of member");
			int t=Integer.parseInt(n);

		if(t==1)
		{
			btn3 = new JRadioButton("3");
			bg.add(btn3);
			btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
			btn3.setBounds(99,177,109,23);
			getContentPane().add(btn3);
		}
		else if(t==2)
		{
			btn3 = new JRadioButton("3");
			bg.add(btn3);
			btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
			btn3.setBounds(99,175,109,23);
			getContentPane().add(btn3);
			btn4 = new JRadioButton("4");
			bg.add(btn4);
			btn4.setFont(new Font("Tahoma", Font.BOLD, 15));
			btn4.setBounds(99,200,109,23);
			getContentPane().add(btn4);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "max limit reached");
		}
	}
		if(ob==VSub)
		{
		if(btn1.isSelected()==true)
		{
			String st="select Nvote from Vote ";
			try
			{
			PreparedStatement ps=c.prepareStatement(st);
			ResultSet rs=ps.executeQuery();
			rs.next();
			a=rs.getInt(1);
			//JOptionPane.showMessageDialog(null, ""+i);
			
			}
			catch(SQLException se)
			{
				
				se.printStackTrace();
			}
			
			i=a+1;
			try
			{
			Statement stm=c.createStatement();
			int rs=stm.executeUpdate("Update vote set Nvote="+i+" where Token=1;");
				if(rs!=0)
				{
				JOptionPane.showMessageDialog(this, "INSERTED");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "NOT INSERTED");
				}
			}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}
		else if(btn2.isSelected()==true)
		{
			String st="select Nvote from Vote ";
			try
			{
			PreparedStatement ps=c.prepareStatement(st);
			ResultSet rs=ps.executeQuery();
			rs.next();
			b=rs.getInt(1);
			//JOptionPane.showMessageDialog(null, ""+i);
			
			}
			catch(SQLException se)
			{
				
				se.printStackTrace();
			}
			
			j=b+1;
			try
			{
			Statement stm=c.createStatement();
			int rs=stm.executeUpdate("Update vote set Nvote="+j+" where Token=2;");
				if(rs!=0)
				{
				JOptionPane.showMessageDialog(this, "INSERTED");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "NOT INSERTED");
				}
			}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}
		else if(btn3.isSelected()==true)
		{
			String st="select Nvote from Vote ";
			try
			{
			PreparedStatement ps=c.prepareStatement(st);
			ResultSet rs=ps.executeQuery();
			rs.next();
			p=rs.getInt(1);
			//JOptionPane.showMessageDialog(null, ""+i);
			
			}
			catch(SQLException se)
			{
				
				se.printStackTrace();
			}
			
			k=p+1;
			try
			{
			Statement stm=c.createStatement();
			int rs=stm.executeUpdate("Update vote set Nvote="+k+" where Token=3;");
				if(rs!=0)
				{
				JOptionPane.showMessageDialog(this, "INSERTED");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "NOT INSERTED");
				}
			}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}
		else if(btn4.isSelected()==true)
		{
			String st="select Nvote from Vote ";
			try
			{
			PreparedStatement ps=c.prepareStatement(st);
			ResultSet rs=ps.executeQuery();
			rs.next();
			d=rs.getInt(1);
			//JOptionPane.showMessageDialog(null, ""+i);
			
			}
			catch(SQLException se)
			{
				
				se.printStackTrace();
			}
			
			l=d+1;
			try
			{
			Statement stm=c.createStatement();
			int rs=stm.executeUpdate("Update vote set Nvote="+l+" where Token=4;");
				if(rs!=0)
				{
				JOptionPane.showMessageDialog(this, "INSERTED");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "NOT INSERTED");
				}
			}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "error");
		}

		}
		if(ob==ex)
		{
			int y=JOptionPane.showConfirmDialog(null, "Sure To Exit");
			if(y==0)
			{
				System.exit(0);
			}
		}
		/*if(ob==res)
		{

			if(i>j && i>k && i>l)
			{
				try {
					Statement stm = c.createStatement();
					ResultSet rs=stm.executeQuery("Select MembName from admdata where Token=1 ;");
					while(rs.next())
					{String n=rs.getString("MembName");
					JOptionPane.showMessageDialog(null,"Winner "+n);}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else if(j>i && j>l && j>k)
			{
				try {
					Statement stm = c.createStatement();
					ResultSet rs=stm.executeQuery("Select MembName from admdata where Token=2 ;");
					while(rs.next())
					{String n=rs.getString("MembName");
					JOptionPane.showMessageDialog(null,"Winner "+n);}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else if(k>i && k>j && k>l)
			{try {
				Statement stm = c.createStatement();
				ResultSet rs=stm.executeQuery("Select MembName from admdata where Token=3 ;");
				while(rs.next())
				{String n=rs.getString("MembName");
				JOptionPane.showMessageDialog(null,"Winner "+n);}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
			else if(l>i && l>j && l>k)
			{
				try {
					Statement stm = c.createStatement();
					ResultSet rs=stm.executeQuery("Select MembName from admdata where Token=4 ;");
					while(rs.next())
					{String n=rs.getString("MembName");
					JOptionPane.showMessageDialog(null,"Winner "+n);}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "please vote");
			}
		}*/
		 
		if(ob==ref)
		{
			new front();
			/*if(btn1.isSelected()==true)
			{
			btn1.setSelected(false);
			}
			else if(btn2.isSelected()==true)
			{
			btn2.setSelected(false);
			}
			else if(btn3.isSelected()==true)
			{
			btn3.setSelected(false);
			}
			else if(btn4.isSelected()==true)
			{
			btn4.setSelected(false);
			}*/
		}
		if(ob==res)
		{
			new Result();
		}

	}
}
