package com.example.gestionRH.entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.gestionRH.enumeration.TypeEmploye;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
    @Column(unique = true, nullable = false)
    private String username;
    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;
    private String telephone;
    @NotNull
    @Size(min = 60, max = 60)
    @Column(length = 60, nullable = false)
    private String password;
    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Size(max = 100)
    @Column(name = "adress", length = 50)
    private String adress;
    @Size(max = 20)
    @Column(name = "city", length = 20)
    private String city;
    @Size(max = 20)
    @Column(name = "country", length = 20)
    private String country;
    @Size(max = 10)
    @Column(name = "postal_code", length = 10)
    private String postalCode;
    
    @Enumerated(EnumType.STRING)
	private TypeEmploye typeEmploye;
    
    @ManyToOne
    @JsonIgnoreProperties("employes")
    private Departement departement;
    
    @ManyToOne
    @JsonIgnoreProperties("employes")
    private Remuneration remuneration;
    
    @OneToMany
    private Set<Employe> sousjacents = new HashSet<>();
    
    @ManyToOne
	private Role role;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Set<Employe> getSousjacents() {
		return sousjacents;
	}
	public void setSousjacents(Set<Employe> sousjacents) {
		this.sousjacents = sousjacents;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public TypeEmploye getTypeEmploye() {
		return typeEmploye;
	}
	public void setTypeEmploye(TypeEmploye typeEmploye) {
		this.typeEmploye = typeEmploye;
	}
	public Remuneration getRemuneration() {
		return remuneration;
	}
	public void setRemuneration(Remuneration remuneration) {
		this.remuneration = remuneration;
	}	

}
