package br.com.elton.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reminder")
public class Reminder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -281765359493049443L;
	
	//****************************************************************
	// ATTRIBUTES
	//****************************************************************
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "messageRead")
	private Boolean messageRead;
	
	@Column(name = "data_creation")
	private LocalDateTime dataCreation;
	
	//****************************************************************
	// GETTERS & SETTERS
	//****************************************************************

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getMessageRead() {
		return messageRead;
	}

	public void setMessageRead(Boolean messageRead) {
		this.messageRead = messageRead;
	}

	public LocalDateTime getDataCreation() {
		return dataCreation;
	}

	public void setDataCreation(LocalDateTime dataCreation) {
		this.dataCreation = dataCreation;
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
		Reminder other = (Reminder) obj;
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
		return "Reminder [id=" + id + ", title=" + title + ", description=" + description + ", messageRead="
				+ messageRead + ", dataCreation=" + dataCreation + "]";
	}
	
}
