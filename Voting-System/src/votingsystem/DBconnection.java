package votingsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnection
{
	static Connection con;
	public static Connection connect()
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Ok");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","123456789");
		System.out.println("connected");
	}
	catch(ClassNotFoundException|SQLException se)
	{
		se.printStackTrace();
	}
	return con;
}
public static void main(String args[])
{
	connect();
}
}
