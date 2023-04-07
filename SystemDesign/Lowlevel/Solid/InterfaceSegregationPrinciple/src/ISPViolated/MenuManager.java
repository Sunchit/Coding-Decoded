package ISPViolated;

import java.util.List;

public class MenuManager {

	public static void main(String[] args) {
		IMenu tasteOfIndia = new TasteOfIndia();
		printMenu(tasteOfIndia.getNonVegetarianItems(), "TasteOfIndia");
		printMenu(tasteOfIndia.getVegetarianItems(), "TasteOfIndia");

		System.out.println("******************");

		IMenu  welcomeToPunjab = new WelcomeToPunjab();
		printMenu(welcomeToPunjab.getNonVegetarianItems(), "WelcomeToPunjab");
		printMenu(welcomeToPunjab.getVegetarianItems(), "WelcomeToPunjab");

	}

	private static void printMenu(List<FOODITEMS> foodItems, String name) {
		if(foodItems!=null && !foodItems.isEmpty()) {
			for (FOODITEMS foodItem : foodItems) {
				System.out.println(name + " has item in menu as " + foodItem);
			}
		}
	}
}
