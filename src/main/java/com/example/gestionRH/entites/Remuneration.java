package com.example.gestionRH.entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Remuneration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(unique = true, nullable = false)
    private String code;
	@Column
    private String description;
	@Column
    private String name;
	
	@OneToMany(mappedBy = "departement")
	private Set<Employe> employes = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		

}
