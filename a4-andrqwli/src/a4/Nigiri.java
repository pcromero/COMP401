package a4;

import a4.Sashimi.SashimiType;

public class Nigiri implements Sushi {

	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	private String name;
	private IngredientPortion[] ing;
	
	public Nigiri(NigiriType type) {
		ing = new IngredientPortion[2];
		if (type == NigiriType.TUNA) {
			this.name = "tuna nigiri";
			this.ing[0] = new TunaPortion(.75);
		} else if (type == NigiriType.YELLOWTAIL) {
			this.name = "yellowtail nigiri";
			this.ing[0] = new YellowtailPortion(.75);
		} else if (type == NigiriType.EEL) {
			this.name = "eel nigiri";
			this.ing[0] = new EelPortion(.75);
		} else if (type == NigiriType.CRAB) {
			this.name = "crab nigiri";
			this.ing[0] = new CrabPortion(.75);
		} else if (type == NigiriType.SHRIMP) {
			this.name = "shrimp nigiri";
			this.ing[0] = new ShrimpPortion(.75);
		}
		
		this.ing[1] = new RicePortion(.5);
	}
	
	public String getName() {
		return name;
	}

	public IngredientPortion[] getIngredients() {
		return ing;
	}

	public int getCalories() {
		double x = 0;
		for (int i = 0; i < ing.length; i++) {
			x += ing[i].getCalories();
		}
		return (int) (x + .5);
	}
	
	public double getCost() {
		double total = 0;
		for (int i = 0; i < ing.length; i++) {
			total += ing[i].getCost();
		}
		
		return (double)Math.round(total * 100d) / 100d;
	}

	public boolean getHasRice() {
		for (int i = 0; i < ing.length; i++) {
			if (!ing[i].getIsRice()) {
				return false;
			}
		}
		return true;
	}

	public boolean getHasShellfish() {
		for (int i = 0; i < ing.length; i++) {
			if (!ing[i].getIsShellfish()) {
				return false;
			}
		}
		return true;
	}

	public boolean getIsVegetarian() {
		for (int i = 0; i < ing.length; i++) {
			if (!ing[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;
	}
}
