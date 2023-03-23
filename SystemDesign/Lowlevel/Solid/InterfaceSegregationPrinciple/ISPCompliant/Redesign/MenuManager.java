package ISPCompliant.Redesign;

import java.util.List;


public class MenuManager {

	public static void main(String[] args) {
		TasteOfIndia tasteOfIndia = new TasteOfIndia();
		printMenu(tasteOfIndia.getVegetrainianItems(), "TasteOfIndia");
		//printMenu(tasteOfIndia.getNonVegetrainianItems(), "TasteOfIndia");

		System.out.println("******************");

		WelcomeToPunjab  welcomeToPunjab = new WelcomeToPunjab();
		printMenu(welcomeToPunjab.getNonVegetrainianItems(), "WelcomeToPunjab");
		printMenu(welcomeToPunjab.getVegetrainianItems(), "WelcomeToPunjab");

	}

	private static void printMenu(List<FOODITEMS> nonVegetrainianItems, String name) {

		for(FOODITEMS fooditem : nonVegetrainianItems){
			System.out.println(name + " has item in menu as" + fooditem);
		}
	}
}
