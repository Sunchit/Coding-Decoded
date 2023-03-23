package ISPCompliant.AdaptorPattern;

import java.util.ArrayList;
import java.util.List;

public class TasteOfIndia implements IVegetrainianMenu {

	public List<FOODITEMS> getVegetrainianItems() {
		List<FOODITEMS> vegFood = new ArrayList<>();
		vegFood.add(FOODITEMS.DAL_MAKNI);
		vegFood.add(FOODITEMS.PANEER_PASANDA);
		return vegFood;
	}


}
