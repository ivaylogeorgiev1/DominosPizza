package dominos.OOP;

import java.util.LinkedList;

public class Dominos implements Iconstants{
	public static void main(String[] args) {
		
	Menu menuDomino = Menu.createMenu();
	Restaurant rest1 = new Restaurant("ulica Lisica", "Purvia restorant na Nasheto Dominos");
	User testuser1 = new User("user1", "111", rest1);

	// salad
		Ingridient tunaSP = new Ingridient("Riba Ton");
		Ingridient onion_SP = new Ingridient("Luk");
		Ingridient rukolaSP = new Ingridient("Rukola");
		Ingridient cornSP = new Ingridient("Carevica");
		Ingridient krutoniSA = new Ingridient("Krutoni");
		Ingridient oliveOilSA = new Ingridient("Maslini");
		// pasta
		// pizza
		
		Ingridient smetanaSausePP = new Ingridient("Smetana sos");
		Ingridient tomatoSausePP = new Ingridient("Domaten sos");
		Ingridient bbqSausePP = new Ingridient("BBQ sos");
		Ingridient mozarelaPI = new Ingridient("Mozarela");
		Ingridient chedarPP = new Ingridient("Cedar");
		Ingridient topenoSurenePI = new Ingridient("Topeno Sirene");
		Ingridient nadenicaPP = new Ingridient("Nadenica");
		Ingridient smokedShunkaPI = new Ingridient("Pushena Shunka");
		Ingridient chorisoPP = new Ingridient("Choriso");
		Ingridient peperoniPP = new Ingridient("Peperoni");
		Ingridient spicyBeefPI = new Ingridient("Pikantno teleshko");
		Ingridient mushroomsPP = new Ingridient("Presni gubi");
		Ingridient basilicumPP = new Ingridient("Bosilek");
		Ingridient pineApplePI = new Ingridient("Ananas");
		Ingridient hlapenjoPeppersPI = new Ingridient("Luti chushki hlapenjo");
		Ingridient parmezanSnowFlakesPI = new Ingridient("Parmezan sneginki");
		// all
		Ingridient pestoSauseAll = new Ingridient("Pesto sos");
		Ingridient smokedBeaconAll = new Ingridient("Pushen becon");
		Ingridient chickenAll = new Ingridient("Pile");
		Ingridient parmeanALL = new Ingridient("Parmezan");
		Ingridient ementalAll = new Ingridient("Emental");
		Ingridient fetaCheesaAll = new Ingridient("Sirene feta");
		Ingridient greenPeppersALL = new Ingridient("Zeleni chuski");
		Ingridient freshTomatosALL = new Ingridient("Presni Domati");
		Ingridient olivesAll = new Ingridient("Maslini");
		Ingridient riganAll = new Ingridient("Rigan");

		Pizza peperoniS = new Pizza(PIZZA_PEPERONI, PIZZA_S, Prices.getTunaCorizanaChicChiricItalianExtravaganzaZvrerskaNewYorkPeperoni());
		Pizza peperoniM = new Pizza(PIZZA_PEPERONI, PIZZA_M, Prices.getTunaCorizanaChicChiricItalianExtravaganzaZvrerskaNewYorkPeperoni());
		Pizza peperoniL = new Pizza(PIZZA_PEPERONI, PIZZA_L, Prices.getTunaCorizanaChicChiricItalianExtravaganzaZvrerskaNewYorkPeperoni());
		Pizza mediteraneoS = new Pizza(PIZZA_MEDITERANEO, PIZZA_S, Prices.getMediteraneoShunkaKlasikGardenKlasikHauwaiKarbonara());
		Pizza mediteraneoM = new Pizza(PIZZA_MEDITERANEO, PIZZA_M, Prices.getMediteraneoShunkaKlasikGardenKlasikHauwaiKarbonara());
		Pizza mediteraneoL = new Pizza(PIZZA_MEDITERANEO, PIZZA_L, Prices.getMediteraneoShunkaKlasikGardenKlasikHauwaiKarbonara());

//		for(Orderable o: menuDomino.getOrderablesList()){
//			System.out.println(o);
//		}
	
	
	
//	for(Ingridient i:peperoniS.getInridients()){
//		System.out.println(i.getName());
//	}
//	testuser1.order(peperoniM.modifyMinus(mozarelaPI));
	testuser1.order(peperoniM.modifyPlus(peperoniPP));
	testuser1.order(peperoniL.modifyMinus(peperoniPP));
//	testuser1.order(Menu.peperoniS);
	testuser1.getKolichka().showShoppigCart();





	}

}
