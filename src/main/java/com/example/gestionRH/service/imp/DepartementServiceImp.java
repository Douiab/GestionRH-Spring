package com.example.gestionRH.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionRH.entites.Departement;
import com.example.gestionRH.repository.DepartementRepository;
import com.example.gestionRH.service.DepartementService;

@Service
public class DepartementServiceImp implements DepartementService{
	
	@Autowired
	DepartementRepository departementRepository;

	@Override
	public Departement create(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public Departement update(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public List<Departement> getAll() {
		return departementRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		departementRepository.deleteById(id);
	}

	@Override
	public Departement getById(Long id) {
		return departementRepository.getOne(id);
	}

}
