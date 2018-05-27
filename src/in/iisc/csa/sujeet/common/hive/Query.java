package in.iisc.csa.sujeet.common.hive;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
//import org.apache.hive.jdbc.HiveDriver;
public class Query {

	private static String driver = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		Connection connect = DriverManager.getConnection("jdbc:hive2://35.185.177.72:10000/default", "anonymous", "anonymous");
		Statement state = connect.createStatement();

		// Query to show databases
		String show = "show databases";
		System.out.println("Running show");
		ResultSet res = state.executeQuery(show);
		if (res.next()) {
			System.out.println(res.getString(1));
		}

	}

}