package ISPCompliant.AdaptorPattern;

import java.util.List;

class VegMenuAdapter implements IVegetarianMenu {

	private final CombinedMenu adaptee;

	public VegMenuAdapter(CombinedMenu combinedMenu) {
		this.adaptee = combinedMenu;
	}

	@Override
	public List<FOODITEMS> getVegetarianItems() {
		return this.adaptee.getVegetarianItems();
	}
}
