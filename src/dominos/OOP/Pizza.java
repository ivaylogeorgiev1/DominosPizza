package dominos.OOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.mysql.fabric.xmlrpc.base.Data;


public class Pizza extends CustomFood implements Iconstants {

	public static final String PIZZA_TESTO_TUNKO = "Tunko i hrupkavo";
	public static final String PIZZA_TESTO_SREDNO = "Italiansko";
	public static final String PIZZA_TESTO_DEBELO = "Tradicionno";
	public static final String CATEGORY_PIZZA = "PIZZA";

	private String size;
	private static Menu menu;
	// private String debelinaNaTestoto;
	private LinkedList<Ingridient> inridients;

	public Pizza(String name, String size, int price) {
		super(name);
		menu = Menu.createMenu();
		if (size.equals(PIZZA_S)) {
			this.setPrice(price);
		} else if (size.equals(PIZZA_M)) {
			this.setPrice(price + Prices.getExtraPriceForMSize());
		} else
		// if (size.equals(PIZZA_L))
		{
			this.setPrice(price + Prices.getExtraPriceForLSize());
		}
		this.inridients = basicPizzaIngridients();
		setSize(size);
		// setDebelinaNaTestoto(debelinaNaTestoto);

		setWeightOrVolume(weightOfPizza(size
		// , debelinaNaTestoto
		));

		menu.addOrderable(this);

	}

	int weightOfPizza(String size
	// , String debelinaNaTestoto
	) {
		if (size.equals(PIZZA_S)) {
			// if (debelinaNaTestoto.equals(Menu.PIZZA_TESTO_SREDNO)) {
			// return 250;
			// }
			return 385;
		}
		if (size.equals(PIZZA_M)) {
			// if (debelinaNaTestoto.equals(Menu.PIZZA_TESTO_TUNKO)) {
			// return 335;
			// } else if (debelinaNaTestoto.equals(Menu.PIZZA_TESTO_SREDNO)) {
			// return 385;
			// }
			return 570;
		}
		if (size.equals(PIZZA_L)) {
			// if (debelinaNaTestoto.equals(Menu.PIZZA_TESTO_SREDNO)) {
			// return 700;
			// }
		}
		return 800;
	}

	static LinkedList<Ingridient> basicPizzaIngridients() {
		LinkedList<Ingridient> basic = new LinkedList<Ingridient>();
		basic.add(new Ingridient("Domaten sos"));
		basic.add(new Ingridient("Mozarela"));
		return basic;
	}

	CustomFood modifyPlus(Ingridient... sustavki) {
		// this.inridients = this.addPizzaSustavki(sustavka);
		for (Ingridient ingri : sustavki) {
			addPizzaSustavki(ingri);
			if (this.size.equals(PIZZA_S)) {
				this.setPrice(this.getPrice() + 1.50);
			}
			if (this.size.equals(PIZZA_M)) {
				this.setPrice(this.getPrice() + 2);
			}
			if (this.size.equals(PIZZA_L)) {
				this.setPrice(this.getPrice() + 2.50);
			}
		}
		return this;
	}

	void addPizzaSustavki(Ingridient ingridient) {

		if (ingridient != null) {

			this.inridients.add(ingridient);

		}

	}

	CustomFood modifyMinus(Ingridient... sustavki) {
		for (Ingridient ingri : sustavki) {
			if (containsSustavka(ingri)) {
				removePizzaSustavki(ingri);
				if (this.size.equals(PIZZA_S)) {
					this.setPrice(this.getPrice() - 1.50);
				}
				if (this.size.equals(PIZZA_M)) {
					this.setPrice(this.getPrice() - 2);
				}
				if (this.size.equals(PIZZA_L)) {
					this.setPrice(this.getPrice() - 2.50);
				}
			}
		}
		return this;
	}

	void removePizzaSustavki(Ingridient ingridient) {
		if (containsSustavka(ingridient)) {
			if (ingridient != null) {
				this.inridients.remove(ingridient);
			}
		}

	}

	boolean containsSustavka(Ingridient ingrid) {
		if (this.inridients.contains(ingrid)) {
			return true;
		}
		return false;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public LinkedList<Ingridient> getInridients() {
		return inridients;
	}

	public void setInridients(LinkedList<Ingridient> inridients) {
		this.inridients = inridients;
	}

}
