package com.example.gestionRH.service;

import java.util.List;

import com.example.gestionRH.entites.Departement;

public interface DepartementService {

	Departement create(Departement departement);

	Departement update(Departement departement);

    List<Departement> getAll();

    void delete(Long id);
}
