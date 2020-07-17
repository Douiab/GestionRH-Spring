package com.example.gestionRH.service;

import java.util.List;

import com.example.gestionRH.entites.Employe;

public interface EmployeService {
	
	Employe create(Employe employe);

	Employe update(Employe employe);

    List<Employe> getAll();

    void delete(Long id);

    Employe findByUsername(String username);

    Employe findByEmail(String email);

    Employe findById(Long id);

}
