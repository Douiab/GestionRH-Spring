package com.example.gestionRH.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionRH.entites.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{
	
	 Optional<Employe> findByUsername(String username);
	 
	 Optional<Employe> findByEmail(String email);
}
