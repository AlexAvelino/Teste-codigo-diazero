package br.com.diazero.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_incidents")
public class Incidents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idIncident;
	
	@Size(min = 3, max = 100)
	private String name;
	
	@Size(min = 5)
	private String description;
	
	private Date createdAt = new java.sql.Date(System.currentTimeMillis());
	
	private Date updatedAt;
	
	private Date closedAt;
	
	// Constructors

	public Incidents() {
	}



	public Incidents(long idIncident, @Size(min = 3, max = 100) String name, @Size(min = 5) String description,
			Date createdAt, Date updatedAt, Date closedAt) {
		super();
		this.idIncident = idIncident;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.closedAt = closedAt;
	}



	public long getIdIncident() {
		return idIncident;
	}

	public void setIdIncident(long idIncident) {
		this.idIncident = idIncident;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
	}
	

}
