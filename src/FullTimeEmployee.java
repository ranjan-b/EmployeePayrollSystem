
public class FullTimeEmployee extends Employee { // sub-class based on employee, with it's own extra variable 
	
	private static final long serialVersionUID = 1L;
	
	private double monthlySalary;
	
	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double calculateSalary() {
		return monthlySalary;
	} 
	
	public double getMonthlySalary() {
		return monthlySalary;
	}
	
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
}
