package dominos.OOP;

public class Sause extends Product{
	public static final String CATEGORY_SAUSE = "SAUSE";

	private static Menu menu;

	Sause(double price, String name, String decription, double weightOrVolume) {
		super(price, name, decription, weightOrVolume);
		menu = Menu.createMenu();
		menu.addOrderable(this);
	}
}
