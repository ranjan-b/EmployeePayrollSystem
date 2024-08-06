import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		PayrollSystem payrollSystem = new PayrollSystem();
		Scanner scanner = new Scanner(System.in);
		
		while(true) { // The main panel that collects the data from the user with data load, store and delete.
			System.out.println("Welcome to the Employee Payroll System");
			System.out.println("1. Add Employee");
			System.out.println("2. Remove Employee");
			System.out.println("3. Display Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Search Employee by ID");
			System.out.println("6. Calculate Total Payroll");
			System.out.println("7. Save to File");
			System.out.println("8. Load to File");
			System.out.println("9. Generate Report");
			System.out.println("10. Exit");
			
			System.out.println("Enter your choice: "); // Enter the first input
			int choice = scanner.nextInt();
			scanner.nextLine(); 
			
			switch(choice) { // creating a switch for different cases based on the option received by the user
			
				case 1: addEmployee(payrollSystem, scanner); break;
				case 2: removeEmployee(payrollSystem, scanner); break;
				case 3: payrollSystem.displayEmployees(); break;
				case 4: updateEmployee(payrollSystem, scanner); break;
				case 5: searchEmployee(payrollSystem, scanner); break;
				case 6: double totalPayroll = payrollSystem.calculateTotalPayroll();
						System.out.println("Total payroll: $" + totalPayroll);
						break;
				case 7: saveToFile(payrollSystem, scanner); break;
				case 8: loadFromFile(payrollSystem, scanner); break;
				case 9: generateReport(payrollSystem, scanner); break;
				case 10: System.out.println("Exiting the system. See you next time!");
						scanner.close();
						System.exit(0);
						
				default: 
						System.out.println("Invalid choice.Please try again.");
			}
			
		}
	}

	// creating different methods based on the option given with each option having their own I/O in the system
	
	private static void generateReport(PayrollSystem payrollSystem, Scanner scanner) {
		System.out.println("Enter filename to generate report: ");
		String filename = scanner.nextLine();
		payrollSystem.generateReport(filename);
	}

	private static void loadFromFile(PayrollSystem payrollSystem, Scanner scanner) {
		System.out.println("Enter filename to load data: ");
		String filename = scanner.nextLine();
		payrollSystem.loadFromFile(filename);
	}

	private static void saveToFile(PayrollSystem payrollSystem, Scanner scanner) {
		System.out.println("Enter filename to save data: ");
		String filename = scanner.nextLine();
		payrollSystem.saveToFile(filename);		
	}

	private static void searchEmployee(PayrollSystem payrollSystem, Scanner scanner) {
		System.out.println("Enter employee ID to search: ");
		int id = scanner.nextInt();
		Employee employee = payrollSystem.searchEmployeeById(id);
		if(employee != null) {
			System.out.println("Employee found: " + employee);
		}
		else {
			System.out.println("Employee with ID " + id + " not found.");
		}		
	}

	private static void updateEmployee(PayrollSystem payrollSystem, Scanner scanner) {
		System.out.println("Enter employee ID to update: ");
		int id = scanner.nextInt();
		payrollSystem.updateEmployee(id);
		
	}

	private static void removeEmployee(PayrollSystem payrollSystem, Scanner scanner) {
		System.out.println("Enter employee ID to remove: ");
		int id = scanner.nextInt();
		payrollSystem.removeEmployee(id);
		
	}

	private static void addEmployee(PayrollSystem payrollSystem, Scanner scanner) {
		System.out.println("Select employee type:");
		System.out.println("1. Full-Time");
		System.out.println("2. Part-Time");
		
		int type =  scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter employee name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter employee ID: ");
		int id = scanner.nextInt();
		
		if(type == 1) {
			System.out.println("Enter monthly salary: ");
			double monthlySalary = scanner.nextDouble();
			Employee employee = new FullTimeEmployee(name, id, monthlySalary);
			payrollSystem.addEmployee(employee);
		} else if(type == 2) {
			System.out.println("Enter hours worked: ");
			int hoursWorked = scanner.nextInt();
			
			System.out.println("Enter hourly rate: ");
			int hourlyRate = scanner.nextInt();
			
			Employee employee = new PartTimeEmployee(name, id, hoursWorked, hourlyRate);
			payrollSystem.addEmployee(employee);
		} else {
			System.out.println("Invalid emloyee type. Returning to main menu.");
		}
		
	}
		

}
