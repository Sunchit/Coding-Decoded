package ISPCompliant.AdaptorPattern;

import java.util.List;

public class NonVegMenuAdapter implements INonVegetrainianMenu {

	private final CombinedMenu adaptee;

	public NonVegMenuAdapter(CombinedMenu combinedMenu) {
		this.adaptee = combinedMenu;
	}

	@Override
	public List<FOODITEMS> getNonVegetrainianItems() {
		return this.adaptee.getNonVegetrainianItems();
	}

}
