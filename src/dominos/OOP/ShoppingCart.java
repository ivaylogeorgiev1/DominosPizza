package dominos.OOP;

import java.util.ArrayList;

public class ShoppingCart {
	private double totalSum;
	private ArrayList<Product> poruchka;
//	private static int currentItem;

	ShoppingCart() {
		totalSum = 0;
		poruchka =new ArrayList<Product>();
	}

	public void showShoppigCart(){
		for(Product item:poruchka){
			System.out.println(item);
		}
		System.out.println("Total sum " + this.totalSum );
	}
	
	public void addItemToShopCart(Product itemOrdered) {
		if (itemOrdered != null) {
			this.poruchka.add(itemOrdered);
			this.totalSum += itemOrdered.getPrice();
		}
	}

	public void deleteItemFromShoppingCart(Product itemOrdered) {
		if (itemOrdered != null) {
			this.poruchka.remove(itemOrdered);
			this.totalSum -= itemOrdered.getPrice();
		}
	}

	public double getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}

	public ArrayList<Product> getPoruchka() {
		return poruchka;
	}

	public void setPoruchka(ArrayList<Product> poruchka) {
		this.poruchka = poruchka;
	}

}
