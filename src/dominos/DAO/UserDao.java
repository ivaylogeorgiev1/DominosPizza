package dominos.DAO;

import dominos.OOP.Product;
import dominos.OOP.User;
import dominos.servlets.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {

	private static IUserDao instance;

	private UserDao() {
	}

	public synchronized static IUserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	public boolean isThereSuchAUser(String username, String email) {
		Connection conn = DBConnection.getInstance().getCon();
		try {
			PreparedStatement ps = conn
					.prepareStatement("Select * from users where username=?;");
			PreparedStatement ps2 = conn
					.prepareStatement("Select * from users where email=?;");
			ps.setString(1, username);
			ps2.setString(1, email);
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			if (rs.next() || rs2.next()) {
				System.out.println("true");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("false");
		return false;
	}

	public void insertIntoProductUsers(String userID, int productID) {
		Connection conn = DBConnection.getInstance().getCon();
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT into productsusers values(?,?,null);");
			ps.setString(1, userID);
			ps.setInt(2, productID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Override
	// public int getTotalQuantity(User user, Product product) {
	//
	// try {
	// Connection con = getConnection();
	// PreparedStatement ps;
	// ps = con.prepareStatement(
	// "SELECT quantity FROM Users_has_Products WHERE Users_id = ? AND Products_id = ?;");
	// ps.setInt(1, user.getId());
	// ps.setInt(2, product.getId());
	//
	// ResultSet result = ps.executeQuery();
	// result.next();
	//
	// return result.getInt(1);
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return 0;
	//
	// }
	//

	// trqbwa da e w productDAO!!!
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			Connection con = DBConnection.getInstance().getCon();
			PreparedStatement ps;
			ps = con.prepareStatement("SELECT p.* from products p;");
			ResultSet result = ps.executeQuery();
			while (result.next()) {

				products.add(new Product(result.getDouble(3), result.getString(2),
						result.getInt(1), result.getString(4)));
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public void registerUser(String username, String password, String email,
			String firstName, String lastName, String restaurant,
			String phoneNumber) {

		Connection con = null;
		con = DBConnection.getInstance().getCon();
		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT into users values(?,?,?,?,?,?,?,?);");
			ps.setString(1, username);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, email);
			ps.setString(6, "normal");
			ps.setString(7, restaurant);
			ps.setString(8, phoneNumber);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User loginUser(String username, String password)
			throws InvalidUserException, DBException {
		Connection con = null;
		try {
			con = DBConnection.getInstance().getCon();
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();

			if (result.next() == false) {
				throw new InvalidUserException("Nema takyv");
			}

			return new User(result.getString(1), result.getString(4),
					result.getString(5), result.getString(7),
					result.getString(3), result.getString(2),
					result.getString(6));

		} catch (InvalidUserException e) {
			throw new InvalidUserException("Nema takyv", e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Bazata neshto ne raboti, sorry", e);
		} finally {
			// try {
			// if (con != null)
			// con.close();
			// } catch (SQLException e) {
			// e.printStackTrace();
			// }
		}
	}

	// private Connection getConnection() throws ClassNotFoundException,
	// SQLException {
	// Connection con;
	// Class.forName("com.mysql.jdbc.Driver");
	// con = DriverManager.getConnection(
	// "jdbc:mysql://192.168.8.22:3306/season5_java2", "ittstudent",
	// "ittstudent-123");
	// return con;
	// }

	// @Override
	// public String getPhotoFileName(int id) throws InvalidUserException {
	// Connection con = null;
	// try {
	// con = getConnection();
	// PreparedStatement ps =
	// con.prepareStatement("SELECT photo FROM Users WHERE id = ?");
	// ps.setInt(1, id);
	// ResultSet result = ps.executeQuery();
	// result.next();
	// return result.getString(1);
	// } catch (ClassNotFoundException | SQLException e) {
	// e.printStackTrace();
	// throw new InvalidUserException("Invalid id for user!");
	// } finally {
	// try {
	// con.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }

	// @Override
	// public void buyThisProduct(User user, Product product, int quantity) {
	// int id = addOrGetProduct(product);
	// product.setId(id);
	//
	// addOrUpdateQuantity(user, product, quantity);
	// }

	// private void addOrUpdateQuantity(User user, Product product, int
	// quantity) {
	// Connection con = null;
	// try {
	// con = getConnection();
	// PreparedStatement ps = con.prepareStatement("SELECT * "
	// + "FROM Users_has_Products WHERE Users_id = ? AND Products_id = ?;");
	// ps.setInt(1, user.getId());
	// ps.setInt(2, product.getId());
	// ResultSet result = ps.executeQuery();
	//
	// if (result.next() == false) {
	// //this user has not bought this product till now
	// PreparedStatement ps2 =
	// con.prepareStatement("INSERT INTO Users_has_Products VALUES(?, ?, ?);");
	// ps2.setInt(1, user.getId());
	// ps2.setInt(2, product.getId());
	// ps2.setInt(3, quantity);
	// ps2.executeUpdate();
	// }
	// else {
	// //this user bought this product already
	// PreparedStatement ps2 =
	// con.prepareStatement("UPDATE Users_has_Products SET quantity = quantity + ? WHERE Users_id = ? AND Products_id = ?");
	// ps2.setInt(1, quantity);
	// ps2.setInt(2, user.getId());
	// ps2.setInt(3, product.getId());
	// ps2.executeUpdate();
	// }
	// }
	// catch (ClassNotFoundException | SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// try {
	// con.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// @Override
	// public int addOrGetProduct(Product product) {
	// Connection con = null;;
	// try {
	// con = getConnection();
	// PreparedStatement ps =
	// con.prepareStatement("SELECT * FROM Products WHERE name = ?");
	// ps.setString(1, product.getName());
	// ResultSet result = ps.executeQuery();
	//
	// if (result.next() == false) {
	// // no such product
	// PreparedStatement ps2 =
	// con.prepareStatement("INSERT INTO Products VALUES(null, ?, ?);",
	// PreparedStatement.RETURN_GENERATED_KEYS);
	// ps2.setString(1, product.getName());
	// ps2.setFloat(2, product.getPrice());
	// ps2.executeUpdate();
	//
	// ResultSet r = ps2.getGeneratedKeys();
	// r.next();
	//
	// return r.getInt(1);
	// }
	// else {
	// return result.getInt(1);
	// }
	// } catch (ClassNotFoundException | SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// try {
	// con.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// return 0;
	// }

}
