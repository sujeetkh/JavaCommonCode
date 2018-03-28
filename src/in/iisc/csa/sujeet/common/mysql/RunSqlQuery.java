package in.iisc.csa.sujeet.common.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunSqlQuery {
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from db limit 2;");
		while (rs.next())
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		con.close();
	}

}
