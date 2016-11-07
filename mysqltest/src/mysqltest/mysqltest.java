package mysqltest;
import java.sql.*;
public class mysqltest {
	String hello="he";
	public static void main(String[] args){
	try {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root", "root");
		Statement st=conn.createStatement();
		//st.execute("insert into student values(10,"hello",10)");
		System.out.println("Done");
	}
	catch(SQLException e)
	{
		System.out.println(e.getMessage());
	}
}
}
