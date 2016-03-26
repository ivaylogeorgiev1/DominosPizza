package dominos.OOP;

public abstract class CustomFood extends Product {



	public CustomFood(String name) {
		super(name);
	}

//	static Ingridient doubleIngridiens(Ingridient ingridient) {
//		StringBuilder temp = new StringBuilder("Dopulnitelno ");
//		return new Ingridient((temp.append(ingridient.getName()).toString()), ingridient.getPrice()*2);
//	}
	abstract CustomFood modifyMinus(Ingridient...sustavka);
	abstract CustomFood modifyPlus(Ingridient...sustavka);

}
