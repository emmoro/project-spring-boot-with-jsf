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
@Table(name="client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6728749332419547755L;
	
	//****************************************************************
	// ATTRIBUTES
	//****************************************************************

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "identification")
	private String identification;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "number")
	private String number;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "state")
	private String state;

	@Column(name = "code_state")
	private String codeState;

	@Column(name = "sex")
	private String sex;

	@Column(name = "cellphone")
	private String cellphone;

	@Column(name = "email")
	private String email;

	@Column(name = "data_creation")
	private LocalDateTime dataCreation;

	@Column(name = "status")
	private Integer status;
	
	@Column(name = "reason_cancellation")
	private String reasonCancellation;
	
	//****************************************************************
	// GETTERS & SETTERS
	//****************************************************************

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCodeState() {
		return codeState;
	}

	public void setCodeState(String codeState) {
		this.codeState = codeState;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public LocalDateTime getDataCreation() {
		return dataCreation;
	}

	public void setDataCreation(LocalDateTime dataCreation) {
		this.dataCreation = dataCreation;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		Client other = (Client) obj;
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
		return "Client [id=" + id + ", name=" + name + ", nationality=" + nationality + ", identification="
				+ identification + ", city=" + city + ", address=" + address + ", phone=" + phone + ", number=" + number
				+ ", birthDate=" + birthDate + ", state=" + state + ", codeState=" + codeState + ", sex=" + sex
				+ ", cellphone=" + cellphone + ", email=" + email + ", dataCreation=" + dataCreation + ", status="
				+ status + ", reasonCancellation=" + reasonCancellation + "]";
	}

}
