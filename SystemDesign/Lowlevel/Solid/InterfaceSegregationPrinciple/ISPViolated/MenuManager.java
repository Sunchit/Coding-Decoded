package ISPViolated;

import java.util.List;

public class MenuManager {

	public static void main(String[] args) {
		IMenu tasteOfIndia = new TasteOfIndia();
		printMenu(tasteOfIndia.getNonVegetrainianItems(), "TasteOfIndia");
		printMenu(tasteOfIndia.getVegetrainianItems(), "TasteOfIndia");

		System.out.println("******************");

		IMenu  welcomeToPunjab = new WelcomeToPunjab();
		printMenu(welcomeToPunjab.getNonVegetrainianItems(), "WelcomeToPunjab");
		printMenu(welcomeToPunjab.getVegetrainianItems(), "WelcomeToPunjab");

	}

	private static void printMenu(List<FOODITEMS> foodItems, String name) {
		if(foodItems!=null && !foodItems.isEmpty()) {
			for (FOODITEMS fooditem : foodItems) {
				System.out.println(name + " has item in menu as " + fooditem);
			}
		}
	}
}
