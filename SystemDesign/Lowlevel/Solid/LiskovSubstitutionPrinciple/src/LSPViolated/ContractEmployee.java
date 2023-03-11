package LSPViolated;

import java.util.List;

public class ContractEmployee extends Employee {

	public ContractEmployee(Integer id, String name) {
		super(id, name);
	}

	@Override
	public Double calculateBonus() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Double getSalary() {
		return 25000d;
	}

	@Override
	public List<Perks> getPerks() {
		return null;
	}
}
