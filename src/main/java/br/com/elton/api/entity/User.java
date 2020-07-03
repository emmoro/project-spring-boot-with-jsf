package br.com.elton.api.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2829198509344270286L;
	
	//****************************************************************
	// ATTRIBUTES
	//****************************************************************
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "*Please provide a user name")
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;

	@NotEmpty(message = "*Please provide your password")
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "date_create")
	private LocalDate dateCreate;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "id_role")
    private Set<UserRole> roles;
	
	//****************************************************************
	// GETTERS & SETTERS
	//****************************************************************

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDate getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(LocalDate dateCreate) {
		this.dateCreate = dateCreate;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//****************************************************************
	// toString
	//****************************************************************

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", active=" + active + ", dateCreate="
				+ dateCreate + ", roles=" + roles + "]";
	}

}
