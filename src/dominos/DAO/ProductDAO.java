package dominos.DAO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dominos.OOP.Product;

public class ProductDAO implements IProductDAO {

	private static IProductDAO instance;

	private ProductDAO() {
	}

	public synchronized static IProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}

	public void addProduct(String name, double price, String desc,
			InputStream inputStream) {
		try {
			Connection con = DBConnection.getInstance().getCon();
			PreparedStatement ps;
			ps = con.prepareStatement("Insert into products values(null,?,?,?,null,null,?)");
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setString(3, desc);
			ps.setBlob(4, inputStream);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Product selectProduct(int id) {
		Product product = null;
		try {
			Connection con = DBConnection.getInstance().getCon();
			PreparedStatement ps;
			ps = con.prepareStatement("SELECT p.* from products p where idProduct=?;");
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {

				product = new Product(result.getDouble(3), result.getString(2),
						result.getInt(1), result.getString(4));
			}
			System.out.println(product);
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// da hvyrlq exception!!!
		return product;
	}

	public String getPhoto(int idProduct) {
		Connection con = DBConnection.getInstance().getCon();
		PreparedStatement ps;
		// OutputStream outputStream=null;
		Blob blob;
		byte[] myBytes = null;
		String relativePath="../../Users/Ivaylo/workspace/DominosPizza/WebContent/images";
		String filePath = "/outImage"+idProduct+".jpg";
		File file = new File(relativePath+filePath);
		if (!file.exists()) {
			try {
				
				file.createNewFile();
				System.out.println("CREATED");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			ps = con.prepareStatement("SELECT  photo from products where idProduct=? ;");
			ps.setInt(1, idProduct);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				blob = resultSet.getBlob(1);
				myBytes = new byte[(int) (blob.length())];
				InputStream inputStream = blob.getBinaryStream();
				OutputStream outputStream = new BufferedOutputStream(
						new FileOutputStream(relativePath+filePath));
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(myBytes)) != -1) {
					outputStream.write(myBytes, 0, bytesRead);
					System.out.println("im in");
				}
				outputStream.close();
				inputStream.close();
				System.out.println("PHOTO READ!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;

		// outputStream=blob.getBinaryStream();
	}

	public Map<String, ArrayList<Integer>> getIdsProductsUsers() {
		Connection con = DBConnection.getInstance().getCon();
		PreparedStatement ps;
		Map<String, ArrayList<Integer>> ids = new HashMap<String, ArrayList<Integer>>();
		try {
			ps = con.prepareStatement("SELECT idUser,idProduct from productsusers;");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				if (!ids.containsKey(resultSet.getString(1))) {
					ids.put(resultSet.getString(1), new ArrayList<Integer>());
				}
				ids.get(resultSet.getString(1)).add(resultSet.getInt(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ids;
	}

	public void deleteOrder(String id) {
		Connection con = DBConnection.getInstance().getCon();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("Delete from productsusers where idUser=?;");
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteProduct(int id) {
		Connection con = DBConnection.getInstance().getCon();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("Delete from products where idProduct=?;");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
