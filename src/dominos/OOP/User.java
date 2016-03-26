package dominos.OOP;

public class User {
	// private int id;
	private String username;
	private String name;
	private String password;
	private String email;
	private String restaurant;
	private String address;
	private String type;

	public User(String username, String password, String email,
			String restaurant, String address, String name, String type) {
		super();
		this.setType(type);
		this.name = name;
		this.address = address;
		this.username = username;
		this.password = password;
		this.email = email;
		this.restaurant = restaurant;
	}

	public String getPK() {
		return username;
	}

	public void setPK(String id) {
		this.username = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
