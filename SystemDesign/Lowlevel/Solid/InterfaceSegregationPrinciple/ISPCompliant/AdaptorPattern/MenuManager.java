package ISPCompliant.AdaptorPattern;

public class MenuManager {

	public static void main(String[] args) {

		CombinedMenu combinedMenu = new CombinedMenu();
		IVegetrainianMenu vegetrainianMenu = new VegMenuAdapter(combinedMenu);
		vegetrainianMenu.getVegetrainianItems();

		INonVegetrainianMenu nonVegetrainianMenu = new NonVegMenuAdapter(combinedMenu);
		nonVegetrainianMenu.getNonVegetrainianItems();
	}

}
