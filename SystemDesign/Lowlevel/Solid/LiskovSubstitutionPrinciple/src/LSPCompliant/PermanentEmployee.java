package LSPCompliant;

import java.util.ArrayList;
import java.util.List;

public class PermanentEmployee extends Employee implements IEmployeeSpecialAllowances {

	public PermanentEmployee(Integer id, String name) {
		super(id, name);
	}

	@Override
	public Double calculateBonus() {
		return 1.20 * this.getSalary();
	}

	@Override
	public Double getSalary() {
		return 100000d;
	}

	@Override
	public List<Perks> getPerks() {
		List<Perks> perksList = new ArrayList<>();
		perksList.add(Perks.LTA);
		perksList.add(Perks.PF);
		perksList.add(Perks.CAR_ALLOWANCE);
		return perksList;
	}
}
