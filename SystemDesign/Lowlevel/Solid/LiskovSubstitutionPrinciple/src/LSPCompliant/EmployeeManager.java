package LSPCompliant;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<>();
		PermanentEmployee permanentEmployeeSunchit = new PermanentEmployee(1, "Sunchit");
		TemporaryEmployee temporaryEmployeeSurbhi = new TemporaryEmployee(2, "Surbhi");
		ContractEmployee contractEmployeeRahul = new ContractEmployee(3, "Rahul");

		employeeList.add(permanentEmployeeSunchit);
		employeeList.add(temporaryEmployeeSurbhi);
		employeeList.add(contractEmployeeRahul);


		System.out.println("Total Salary of all employees is " + fetchTotalSalary(employeeList));

		List<IEmployeeSpecialAllowances> employeeListWithSpecialAllowances = new ArrayList<>();
		employeeListWithSpecialAllowances.add(permanentEmployeeSunchit);
		employeeListWithSpecialAllowances.add(temporaryEmployeeSurbhi);
		//employeeListWithSpecialAllowances.add(contractEmployeeRahul);

		System.out.println("Total bonus budget of all employees is " + fetchTotalBonusBudget(employeeListWithSpecialAllowances));
		printPerksOfEachEmployee(employeeListWithSpecialAllowances);

	}

	private static Double fetchTotalBonusBudget(List<IEmployeeSpecialAllowances> employeeList) {
		Double totalBonus = 0d;
		for(IEmployeeSpecialAllowances employee : employeeList){
			totalBonus += employee.calculateBonus();
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


	private static void printPerksOfEachEmployee(List<IEmployeeSpecialAllowances> employeeList) {

		for(IEmployeeSpecialAllowances employee : employeeList){

			String perkList = new String();
			if(employee.getPerks() !=null) {
				for (Perks perk : employee.getPerks()) {
					perkList += perk + " ";
				}
				System.out.println("Perks are " + perkList);
			}
		}


	}

}
