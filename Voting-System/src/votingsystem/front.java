package votingsystem;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;




import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;


public class front extends JFrame implements ActionListener{
	private JButton New;
	private JButton Vo;
	private JButton Ad;
	private JButton Exit;
	
	public front(){
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		setSize(new Dimension(357, 292));
		getContentPane().setLayout(null); 
		
		JLabel lblWelcomeToVoting = new JLabel("Welcome to Voting System");
		lblWelcomeToVoting.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeToVoting.setBounds(79, 11, 206, 22);
		getContentPane().add(lblWelcomeToVoting);
		
		JLabel lblPleaseSelectOne = new JLabel("YOU ARE");
		lblPleaseSelectOne.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPleaseSelectOne.setBounds(144, 55, 68, 22);
		getContentPane().add(lblPleaseSelectOne);
		
		Ad = new JButton("Admin");
		Ad.setFont(new Font("Tahoma", Font.BOLD, 14));
		Ad.setBounds(134, 97, 89, 23);
		getContentPane().add(Ad);
		
		Vo = new JButton("Voter");
		Vo.setFont(new Font("Tahoma", Font.BOLD, 14));
		Vo.setBounds(134, 131, 89, 23);
		getContentPane().add(Vo);
		New = new JButton("New Voter");
		New.setFont(new Font("Tahoma", Font.BOLD, 14));
		New.setBounds(121, 165, 113, 23);
		getContentPane().add(New);
		
		Exit = new JButton("EXIT");
		Exit.setFont(new Font("Tahoma", Font.BOLD, 15));
		Exit.setBounds(292, 228, 89, 23);
		getContentPane().add(Exit);
		setLocationRelativeTo(null);
		Ad.addActionListener(this);
		Vo.addActionListener(this);
		New.addActionListener(this);
		Exit.addActionListener(this);
		setVisible(true);
		setSize(397,291);
		setResizable(false);
	}

	public static void main(String[] args) {
		new front();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob== Ad)
		{
			new Adminlogin();
		}
		else if(ob==Vo)
		{
			new Voterlogin();
		}
		else if(ob==New)
		{
			new NewReg();
		}
		else if(ob==Exit)
		{
			int yn=JOptionPane.showConfirmDialog(this, "SURE TO EXIT");
			if(yn==0)
			{
				System.exit(0);
			}
		}
		
	}
}
