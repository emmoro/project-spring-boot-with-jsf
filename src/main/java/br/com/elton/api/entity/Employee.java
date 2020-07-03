package br.com.elton.api.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3321877981712214991L;

	//****************************************************************
	// ATTRIBUTES
	//****************************************************************

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "cellphone")
	private String cellphone;

	@Column(name = "email")
	private String email;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "identification")
	private String identification;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "code_state")
	private String codeState;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	@Column(name = "number")
	private String number;

	@Column(name = "status")
	private Integer status;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "reason_leaving")
	private String reasonLeaving;
	
	@Column(name = "data_creation")
	private LocalDateTime dataCreation;
	
	@Column(name = "reason_cancellation")
	private String reasonCancellation;
	
	//****************************************************************
	// GETTERS & SETTERS
	//****************************************************************

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getCodeState() {
		return codeState;
	}

	public void setCodeState(String codeState) {
		this.codeState = codeState;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getReasonLeaving() {
		return reasonLeaving;
	}

	public void setReasonLeaving(String reasonLeaving) {
		this.reasonLeaving = reasonLeaving;
	}

	public LocalDateTime getDataCreation() {
		return dataCreation;
	}

	public void setDataCreation(LocalDateTime dataCreation) {
		this.dataCreation = dataCreation;
	}
	
	public String getReasonCancellation() {
		return reasonCancellation;
	}

	public void setReasonCancellation(String reasonCancellation) {
		this.reasonCancellation = reasonCancellation;
	}
	
	//****************************************************************
	// HASH CODE & EQUALS
	//****************************************************************

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//****************************************************************
	// toString
	//****************************************************************

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", cellphone=" + cellphone + ", email="
				+ email + ", nationality=" + nationality + ", identification=" + identification + ", birthDate="
				+ birthDate + ", codeState=" + codeState + ", city=" + city + ", address=" + address + ", number="
				+ number + ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", reasonLeaving=" + reasonLeaving + ", dataCreation=" + dataCreation + ", reasonCancellation="
				+ reasonCancellation + "]";
	}
	
}
