
public class PartTimeEmployee extends Employee { // sub-class based on employee, with it's own extra variables
	
	private static final long serialVersionUID = 1L;
	
	private int hoursWorked;
	private int hourlyRate;
	
	public PartTimeEmployee(String name, int id, int hoursWorked, int hourlyRate) { // Part-time employees with different set of variables that defines the inputs needed 
		super(name, id);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
		
	}
	
	@Override
	public double calculateSalary() {
		return hoursWorked * hourlyRate;
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}
	
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	public int getHourlyRate() {
		return hourlyRate;
	}
	
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
