package com.pwi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="company")
public class Company {
	
	@OneToMany(mappedBy="company", fetch = FetchType.EAGER)
	private Set<Country> country;


	public Set<Country> getCountry() {
		return country;
	}

	public void setCountry(Set<Country> country) {
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Comapny name cannot be empty")
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
