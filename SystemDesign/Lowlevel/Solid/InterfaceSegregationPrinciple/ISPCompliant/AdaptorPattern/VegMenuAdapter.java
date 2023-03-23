package ISPCompliant.AdaptorPattern;

import java.util.List;

class VegMenuAdapter implements IVegetrainianMenu {

	private final CombinedMenu adaptee;

	public VegMenuAdapter(CombinedMenu combinedMenu) {
		this.adaptee = combinedMenu;
	}

	@Override
	public List<FOODITEMS> getVegetrainianItems() {
		return this.adaptee.getVegetrainianItems();
	}
}
