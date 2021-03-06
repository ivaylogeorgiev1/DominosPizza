package dominos.DAO;

import java.sql.*;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/dominos_db";
	private static String passwordDB = "123456";
	private static String userDB = "root";

	private static DBConnection instance = null;

	private Connection conn;

	DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, userDB, passwordDB);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static DBConnection getInstance() {
		synchronized (DBConnection.class) {
			if (instance == null) {
				instance = new DBConnection();
			}
			return instance;
		}
	}

	public Connection getCon() {
		return conn;
	}
}
