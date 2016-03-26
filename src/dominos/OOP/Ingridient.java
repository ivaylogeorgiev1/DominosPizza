package dominos.OOP;

public class Ingridient extends Product {
	private String name;
	private double priceOfIngridien;
	private static Menu menu;

	public Ingridient(String name) {
		super(name);
		menu = Menu.createMenu();
		menu.addOrderable(this);
	}

	
	
	
	
	
	
	
	
	
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		if (name != null) {
//			this.name = name;
//		}
//	}

//	public double getPriceOfIngridien() {
//		return priceOfIngridien;
//	}
//
//	public void setPriceOfIngridien(double priceOfIngridien) {
//		if (priceOfIngridien > 0) {
//			this.priceOfIngridien = priceOfIngridien;
//		}
//	}

}