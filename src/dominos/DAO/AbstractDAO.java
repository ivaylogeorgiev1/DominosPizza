package dominos.DAO;

import java.sql.Connection;

public abstract class AbstractDAO {
	private static final Connection con = DBConnection.getInstance()
			.getCon();

	public static Connection getCon() {
		return con;
	}

}
