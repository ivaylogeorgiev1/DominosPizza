package dominos.OOP;

public class Drink extends Product {
	public static final String CATEGORY_DRINKS = "DRINKS";
	private static Menu menu;

	Drink(double price, String name, String decription, double weightOrVolume) {
		super(price, name, decription, weightOrVolume);
		menu = Menu.createMenu();
		menu.addOrderable(this);
	}
}