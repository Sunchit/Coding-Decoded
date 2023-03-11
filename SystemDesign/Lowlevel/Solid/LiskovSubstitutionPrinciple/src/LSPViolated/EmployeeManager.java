package LSPViolated;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import LSPCompliant.IEmployeeSpecialAllowances;

public class EmployeeManager {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<>();
		PermanentEmployee permanentEmployeeSunchit = new PermanentEmployee(1,"Sunchit" );
		TemporaryEmployee temporaryEmployeeSurbhi = new TemporaryEmployee(2, "Surbhi");
		ContractEmployee contractEmployeeRahul = new ContractEmployee(3, "Rahul");

		employeeList.add(permanentEmployeeSunchit);
		employeeList.add(temporaryEmployeeSurbhi);
		employeeList.add(contractEmployeeRahul);

		System.out.println("Total salary of all employees is " + fetchTotalSalary(employeeList));
		System.out.println("Total bonus budget of all employees is " + fetchTotalBonusBudget(employeeList));
		printPerksOfEachEmployee(employeeList);
	}

	private static Double fetchTotalBonusBudget(List<Employee> employeeList) {
		Double totalBonus = 0d;
		for(Employee employee : employeeList){
			if(!(employee instanceof ContractEmployee)) {
				totalBonus += employee.calculateBonus();
			}
		}
		return totalBonus;
	}

	private static Double fetchTotalSalary(List<Employee> employeeList) {
		Double totalSalary = 0d;
		for(Employee employee : employeeList){
			totalSalary += employee.getSalary();
		}
		return totalSalary;

	}

	private static void printPerksOfEachEmployee(List<Employee> employeeList) {

		for(Employee employee : employeeList){

				String perkList = new String();
				if(employee.getPerks() !=null) {
					for (Perks perk : employee.getPerks()) {
						perkList += perk + " ";
					}
					System.out.println("Employee id " + employee.getId() + " with name " + employee.getName() + " has perks as " + perkList);
				}
			}


	}

}
