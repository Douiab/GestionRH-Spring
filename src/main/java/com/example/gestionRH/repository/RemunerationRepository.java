package com.example.gestionRH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionRH.entites.Remuneration;

@Repository
public interface RemunerationRepository extends JpaRepository<Remuneration, Long>{

}
