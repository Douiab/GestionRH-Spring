package com.example.gestionRH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionRH.entites.Departement;

@Repository
public interface DepartementRepository  extends JpaRepository<Departement, Long>{

}
