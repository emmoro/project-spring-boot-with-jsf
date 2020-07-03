package br.com.elton.api.web.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.elton.api.entity.Employee;
import br.com.elton.api.enun.Status;
import br.com.elton.api.service.EmployeeService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component("employeeBean")
@Scope("request")
public class EmployeeBean {
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    /** Variaveis   */
	
	private Employee employee = new Employee();
	
	private Employee employeeFilter = new Employee();
	
	private List<Employee> listEmployee =  new ArrayList<Employee>();
	
	@Autowired
	private EmployeeService employeeService;
	
	private Employee employeeSelected;
	
	private String formattedDate;
	
	/** Metodos   */
	
	public void init() {
		
		listEmployee = new ArrayList<Employee>();

	}
	
	public void clean() {
		employee = new Employee();
		formattedDate = null;
	}
	
	public String back() {
		
		return "searchEmployee.xhtml";
	}
	
	public void saveEmployee() {
		
		if (validateEmployee()) {
			
			employee.setBirthDate(LocalDate.parse(formattedDate,formatter));
			employee.setDataCreation(LocalDateTime.now());
			employee.setStatus(Status.ACTIVE.getId());
			employeeService.saveEmployee(employee);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro", "Salvo com Sucesso."));
	
			employee = new Employee();
			formattedDate = null;
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cadastro", "Preencha os campos obrigatórios *."));
		}
	}
	
	public void searchEmployeeFilter() {
		
		listEmployee = employeeService.findEmployee(employeeFilter);
		
	}
	
	public String view() {

		if (employeeSelected != null) {
			employee = employeeSelected;
		}

		return "viewEmployee.xhtml";
	}
	
	public String change() {

		if (employeeSelected != null) {
			employee = employeeSelected;
		}

		return "employeeRegister.xhtml";
	}
	
	public String viewCancel() {
		
		if (employeeSelected != null) {
			employee = employeeSelected;
		}

		return "cancelEmployee.xhtml";
		
	}
	
	public void cancel() {
		
		if (validateCancel()) {
			employee.setStatus(0);
//			funcionario.setDataSaida(new Date());
			employeeService.saveEmployee(employee);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelamento",
					"Cadastro do Funcionário foi Cancelado com Sucesso."));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cadastro", "Preencha os campos obrigatórios *."));
		}
		
	}
	
	private boolean validateEmployee() {
		
		boolean validate = true;
		
		if (employee.getName().isEmpty()) {
			validate = false;
		}
		
//		if (funcionario.getCpf().isEmpty()) {
//			validar = false;
//		}
//		
//		if (funcionario.getTelefone().isEmpty()) {
//			validar = false;
//		}
//		
//		if (funcionario.getEndereco().isEmpty()) {
//			validar = false;
//		}
//		
//		if (funcionario.getBairro().isEmpty()) {
//			validar = false;
//		}
//		
//		if (funcionario.getCidade().isEmpty()) {
//			validar = false;
//		}
		
		return validate;
	}

	private boolean validateCancel() {
		
		boolean validate = true;
		
		if (employee.getReasonCancellation().isEmpty()) {
			validate = false;
		}
		
		return validate;
	}
	
	/** Getters e Setters   */

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public Employee getEmployeeFilter() {
		return employeeFilter;
	}

	public void setEmployeeFilter(Employee employeeFilter) {
		this.employeeFilter = employeeFilter;
	}

	public Employee getEmployeeSelected() {
		return employeeSelected;
	}

	public void setEmployeeSelected(Employee employeeSelected) {
		this.employeeSelected = employeeSelected;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

}
