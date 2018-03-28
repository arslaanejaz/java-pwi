package com.pwi.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="country")
public class Country {

	@OneToMany(mappedBy="country", fetch = FetchType.EAGER)
	private Set<Warehouse> warehouse;
	
	public Set<Warehouse> getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Set<Warehouse> warehouse) {
		this.warehouse = warehouse;
	}

	
	//reverse
    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name="country_id", nullable=false)
    @JsonIgnore
    private Company company;
    
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Country name cannot be empty")
	@Size(min=1, max=30)
	@Column(name = "name", unique=false, nullable = false)
	private String name;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
