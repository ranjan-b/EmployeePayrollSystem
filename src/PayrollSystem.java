import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {
	
	private ArrayList<Employee> employeeList;
	private Scanner scanner;
	
	public PayrollSystem() {
		employeeList = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
		System.out.println("Employee added successfully.");
	}
	
	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		
		for(Employee employee : employeeList) {
			if(employee.getId() == id) {
				employeeToRemove = employee;
				break;	
			}
		}  
		
		if(employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
			System.out.println("Employee with ID #" + id + " has been removed successfully.");
		}
		else {
			System.out.println("Employee with ID #" + id + " not found.");
		}		
	}
	
	
	public void displayEmployees() {	
		if(employeeList.isEmpty()) {
			System.out.println("No employees to display.");
		} else {
			for(Employee employee : employeeList) {
				System.out.println(employee);
			}	
		}
	}
	
	public Employee searchEmployeeById(int id) {
		for(Employee employee : employeeList) {
			if(employee.getId() == id) {
				return employee;
			}
		}
		return null;	
	}
	
	public void updateEmployee(int id) {
		Employee employee = searchEmployeeById(id);
		if(employee == null) {
			System.out.println("Employee with ID #" + id + " not found.");
			return;
		}
		
		System.out.println("Select field to update:");
		System.out.println("1. Name");
		if(employee instanceof FullTimeEmployee) {
			System.out.println("2. Monthly Salary");
		}
		else if(employee instanceof PartTimeEmployee) {
			System.out.println("2. Hours Worked");
			System.out.println("3. Hourly Rate");
		}
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Enter new name: ");
			String newName = scanner.nextLine();
			employee.setName(newName);
			System.out.println("Name updated successfully.");
			break;
		
		case 2:
			if(employee instanceof FullTimeEmployee) {
				System.out.println("Enter new monthly salary: ");
				double newSalary = scanner.nextDouble();
				((FullTimeEmployee) employee).setMonthlySalary(newSalary);
				System.out.println("Monthly salary updated successfully");
			} else if(employee instanceof PartTimeEmployee) {
				System.out.println("Enter new hours worked: ");
				int newHours = scanner.nextInt();
				((PartTimeEmployee) employee).setHoursWorked(newHours);
				System.out.println("Hours worked updated successfully.");
			}
			break;
			
		case 3:
			if(employee instanceof PartTimeEmployee) {
				System.out.println("Enter new hourly rate: ");
				int newHourlyRate = scanner.nextInt();
				((PartTimeEmployee) employee).setHourlyRate(newHourlyRate);
				System.out.println("Hourly rate updated successfully.");
			}
			break;
				default: 
					System.out.println("Invalid choice.");
			}
		}
	
	public double calculateTotalPayroll() {
		double total = 0.0;
		for(Employee employee:  employeeList) {
			total += employee.calculateSalary();
			
		}
		return total;
	}
		
	public void saveToFile(String filename) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(employeeList);
			System.out.println("Employee data saved.");
		} catch (IOException e) {
			System.out.println("Error saving data.");
		}
	}
	
	public void loadFromFile(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			employeeList = (ArrayList<Employee>) ois.readObject();
			System.out.println("Employee data loaded from " + filename);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading data: " + e.getMessage());
		}
	}
	
	public void generateReport(String filename) {
		try(PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.println("Employee Report");
			writer.println("---------------");
			for(Employee employee : employeeList) {
				writer.println(employee);
			}
			writer.println("Total Payroll: $" + calculateTotalPayroll());
			System.out.println("Report generated: " + filename);
			
		} catch (IOException e) {
			System.out.println("Error generating report: " + e.getMessage());;
		}
	}	
}
