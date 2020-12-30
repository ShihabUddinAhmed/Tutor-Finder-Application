import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
public class DatabaseLink
{
	public Connection connect;
	public Statement arg;
	public ResultSet product;
	private String driverPack;
	private String dbUrl;
	private String userName;
	private String password;
	public DatabaseLink()
	{
		driverPack="com.mysql.jdbc.Driver";
		dbUrl="jdbc:mysql://localhost:3306/tutorfinder";
		userName="root";
		password="";
		try
		{
			Class.forName(driverPack);
			System.out.println("Attempting For Connection...");
			connect=DriverManager.getConnection(dbUrl,userName,password);
			System.out.println("Connection Successful.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
                     "Error in Connection...",
                     "Warning",
                     JOptionPane.WARNING_MESSAGE);
		}
	}
	public void close() throws SQLException
	{
		if(product!=null){product.close();}
		if(product!=null){arg.close();}
	}
	public ResultSet getProduct(String query)
	{
		try
		{
			arg=connect.createStatement();
			product=arg.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
			"Error When Collecting Data...",
			"Warning",
			JOptionPane.WARNING_MESSAGE);
		}
		return product;
	}
	public int ddlOperation(String sql)
	{
		int rowsUpdated=0;
		try
		{
			arg=connect.createStatement();
			rowsUpdated=arg.executeUpdate(sql);
			System.out.println(rowsUpdated+"Rows Updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
			"Error When Updating Data...",
			"Warning",
			JOptionPane.WARNING_MESSAGE);
		}
		return rowsUpdated;
	}
}