package dominos.DAO;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import dominos.OOP.Product;

public interface IProductDAO {
	Product selectProduct(int id);

	public Map<String, ArrayList<Integer>> getIdsProductsUsers();

	public void deleteOrder(String id);

	public void addProduct(String name, double price, String desc,InputStream inputStream);

	public void deleteProduct(int id);
	public String getPhoto(int idProduct) ;

}
