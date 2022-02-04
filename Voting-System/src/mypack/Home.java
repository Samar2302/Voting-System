package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener  {
	private JMenuItem exit;
	private JMenuItem m2;
	private JMenuItem m1;
	private JMenuItem all;
	private JMenuItem id;
	private JMenuItem delete;
	private JMenuItem update;
	private JMenuItem add;

	public Home() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		setSize(dim);
	
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEmployee = new JMenu("Employee");
		mnEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnEmployee);
		
		add = new JMenuItem("Add");
		mnEmployee.add(add);
		
		update = new JMenuItem("Update\r\n");
		mnEmployee.add(update);
		
		delete = new JMenuItem("Delete");
		mnEmployee.add(delete);
		mnEmployee.addSeparator();
		
		JMenu mnView = new JMenu("View");
		mnEmployee.add(mnView);
		
		id = new JMenuItem("By ID");
		mnView.add(id);
		
		all = new JMenuItem("View All");
		mnView.add(all);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnMenu);
		
		m1 = new JMenuItem("M-1");
		mnMenu.add(m1);
		
		m2 = new JMenuItem("M-2");
		mnMenu.add(m2);
		
		exit = new JMenuItem("Exit");
		mnMenu.add(exit);
		setLocationRelativeTo(null);
		add.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		id.addActionListener(this);
		all.addActionListener(this);
		m1.addActionListener(this);
		m2.addActionListener(this);
		exit.addActionListener(this);
		
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new Home();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==add)
		{
			new EmployeeNew();
		}
		else if(ob==update){
			String st=JOptionPane.showInputDialog(this,"Enter ID");
			int p=Integer.parseInt(st);
			new EmployeeUpdate(p);
		}
		else if(ob==delete){}
		else if(ob==m1){
			new controls();
		}
		else if(ob==all){}
		else if(ob==id){}
		else if(ob==m2){}
		else if(ob==exit){
			int yn=JOptionPane.showConfirmDialog(this, "sure to exit");
			if(yn==0)
			{
				System.exit(0);
			}
		}
		
		
	}

}
