package dominos.OOP;

public class IceCream extends Product {
	public static final String CATEGORY_ICE = "ICE CREAM";
	private static Menu menu;

	IceCream(double price, String name, String decription, double weightOrVolume) {
		super(price, name, decription, weightOrVolume);
		menu = Menu.createMenu();
		menu.addOrderable(this);
	}
}
