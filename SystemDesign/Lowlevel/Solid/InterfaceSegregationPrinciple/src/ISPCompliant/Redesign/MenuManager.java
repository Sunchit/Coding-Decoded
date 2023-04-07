package ISPCompliant.Redesign;

import java.util.List;


public class MenuManager {

	public static void main(String[] args) {
		TasteOfIndia tasteOfIndia = new TasteOfIndia();
		printMenu(tasteOfIndia.getVegetarianItems(), "TasteOfIndia");
		//printMenu(tasteOfIndia.getNonVegetarianItems(), "TasteOfIndia");

		System.out.println("******************");

		WelcomeToPunjab  welcomeToPunjab = new WelcomeToPunjab();
		printMenu(welcomeToPunjab.getNonVegetarianItems(), "WelcomeToPunjab");
		printMenu(welcomeToPunjab.getVegetarianItems(), "WelcomeToPunjab");

	}

	private static void printMenu(List<FOODITEMS> items, String name) {

		for(FOODITEMS foodItem : items){
			System.out.println(name + " has item in menu as " + foodItem);
		}
	}
}
