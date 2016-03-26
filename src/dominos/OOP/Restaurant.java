package dominos.OOP;

import dominos.database.DominosDatabase;

public class Restaurant {
String addressOfTheRestaurant;
String nameOfTheRestaurant;

public Restaurant(String addressOfTheRestaurant, String nameOfTheRestaurant) {
	
	this.addressOfTheRestaurant = addressOfTheRestaurant;
	this.nameOfTheRestaurant = nameOfTheRestaurant;
	DominosDatabase.addRestaurantDB(addressOfTheRestaurant, nameOfTheRestaurant);
}	


}
