package br.com.elton.api.service;

import java.util.List;

import br.com.elton.api.entity.Employee;

public interface EmployeeService {

	/**
	 * Save Employee
	 * @param employee
	 */
	public abstract void saveEmployee(Employee employee);
	
	/**
	 * Find all Employee
	 * @param Employee employee
	 * @return List<Employee>
	 */
	public abstract List<Employee> findEmployee(Employee employee);
	
	/**
	 * Count all Employee
	 * @return Integer
	 */
	public abstract Integer countActiveEmployee();
	
}
