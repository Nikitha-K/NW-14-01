package rest;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	private static Employees list = new Employees();
	static {
		 list.getEmployeeList().add(new Employee(1, "Lokesh Gupta", "lokesh@gmail.com"));
	        list.getEmployeeList().add(new Employee(2, "Alex Kolenchiskey", "alex@gmail.com"));
	        list.getEmployeeList().add(new Employee(3, "David Kameron", "david@gmail.com"));
	}
	public Employees getAllEmployees() {
		return list;
	}
	public void addEmployee(Employee employee) {
		list.getEmployeeList().add(employee);
	}
}
