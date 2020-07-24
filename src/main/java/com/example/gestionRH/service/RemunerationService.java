package com.example.gestionRH.service;

import java.util.List;

import com.example.gestionRH.entites.Remuneration;

public interface RemunerationService {
	
	Remuneration create(Remuneration remuneration);

	Remuneration update(Remuneration remuneration);

    List<Remuneration> getAll();
    
    Remuneration getById(Long id);

    void delete(Long id);

}
