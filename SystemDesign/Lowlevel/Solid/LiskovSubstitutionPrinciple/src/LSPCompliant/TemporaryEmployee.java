package LSPCompliant;

import java.util.ArrayList;
import java.util.List;

public class TemporaryEmployee extends Employee implements  IEmployeeSpecialAllowances {

	public TemporaryEmployee(Integer id, String name) {
		super(id, name);
	}

	@Override
	public Double calculateBonus() {
		return 0.9 * this.getSalary();
	}

	@Override
	public Double getSalary() {
		return 50000d;
	}

	@Override
	public List<Perks> getPerks() {
		List<Perks> perksList = new ArrayList<>();
		perksList.add(Perks.LTA);
		perksList.add(Perks.PF);
		return  perksList;
	}

}
