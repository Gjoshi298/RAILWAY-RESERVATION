package Railway;

import java.sql.*;
public class sigindatabase
{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	sigindatabase()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayreservation","root","root");
				pst=con.prepareStatement("select * from user_details where name=? and password=?");
	}
	catch(Exception e)
		{
		System.out.println(e);
		}
}
	public Boolean checkLogin(String name,String password)
	{
		try
		{
			
			pst.setString(1,name);
			pst.setString(2,password);
			rs=pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	}
}