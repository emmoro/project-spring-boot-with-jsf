package br.com.elton.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elton.api.entity.Employee;
import br.com.elton.api.repository.EmployeeRepository;
import br.com.elton.api.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);		
	}

	@Override
	public List<Employee> findEmployee(Employee employee) {
		return employeeRepository.findAll();
	}
	
	@Override
	public Integer countActiveEmployee() {
		return (int) employeeRepository.count();
	}

}
