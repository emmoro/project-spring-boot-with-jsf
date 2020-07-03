package br.com.elton.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7465841945644026689L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name = "role")
    private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}
