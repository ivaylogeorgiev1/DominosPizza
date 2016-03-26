package dominos.OOP;

public class Product {
	private double price;
	private String name;
	private String decription;
	private double weightOrVolume;
	private int id;

	Product(String name) {
		setName(name);

	}

	public Product(double price, String name, int id,String desc) {
		setPrice(price);
		setName(name);
		this.decription=desc;
		this.id = id;
	}

	public Product(int price, String name, String decription,
			double weightOrVolume) {
		setPrice(price);
		setName(name);
		setDecription(decription);
		setWeightOrVolume(weightOrVolume);

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		if (decription != null) {
			this.decription = decription;
		}
	}

	public double getWeightOrVolume() {
		return weightOrVolume;
	}

	public void setWeightOrVolume(double weightOrVolume) {
		if (weightOrVolume > 0) {
			this.weightOrVolume = weightOrVolume;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	@Override
	public String toString() {
		if (this.name != null) {
			return name + "\t" + price;
		}
		return "";
	}

	public int getId() {
		return id;
	}

}
