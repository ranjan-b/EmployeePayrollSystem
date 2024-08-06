import java.io.Serializable;

abstract class Employee implements Serializable { // Using abstract class for more secure access
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int id;
	
	public abstract double calculateSalary();
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {  // Using Encapsulation to access the variables from main class
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("Employee [Name = %s, Id = %d, Salary = $%.2f]", name, id, calculateSalary());
	}	

}
