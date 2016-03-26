package dominos.OOP;

import java.sql.*;

public class DemoForData {

	public static void main(String[] args) {
		try {
			Connection myConn = DriverManager.getConnection(
					"jdbs:mysql://localhost:3306/hr", "root", "123456");
			Statement myStmt = myConn.createStatement();
			String sql = "insert into regions " + "region_id, region_name"
					+ "values('5','atlantic')";
			myStmt.executeUpdate(sql);
			// String sql = "insert into users "
			// + "username,firstName,lastName,password"
			// + "values ('Ivaylooo','Ivaylo','Georgiev','123'	";
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
