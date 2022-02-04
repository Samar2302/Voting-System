package mypack;


import java.sql.*;
public class DBConnection
{
	static Connection con;
	public static Connection connect()
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Ok");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/samar","root","1234");
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
/*1.Expand project
 *2.right click on src
 *3. new-->folder
 *4.make a folder named bin
 *5.copy the req. jar file into bin
 *6.right click on package (samar)
 *7.click on build path--> configure build path
 *8.click on libraries expand project
 *9.select the copied jar file
 *10. click ok */
 