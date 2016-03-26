package dominos.DAO;
import java.util.List;

import dominos.OOP.Product;
import dominos.OOP.User;

public interface IUserDao {

	User loginUser(String username, String password) throws InvalidUserException, DBException;
//
//	String getPhotoFileName(int id) throws InvalidUserException;
	public boolean isThereSuchAUser(String username, String email) ;
//	
	public List<Product> getProducts() ;
	
	 void registerUser(String username, String password, String email,
				String firstName, String lastName, String restaurant,
				String phoneNumber);
		public void insertIntoProductUsers(String userID, int productID) ;
//	int getTotalQuantity(User user, Product product);
//
//	void buyThisProduct(User user, Product product, int quantity);
//
//	int addOrGetProduct(Product product);
}
