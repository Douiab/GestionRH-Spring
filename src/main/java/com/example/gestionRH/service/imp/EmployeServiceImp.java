package com.example.gestionRH.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionRH.entites.Employe;
import com.example.gestionRH.repository.EmployeRepository;
import com.example.gestionRH.service.EmployeService;

@Service
public class EmployeServiceImp implements EmployeService {

	@Autowired
	EmployeRepository employeRepository;
	
	@Override
	public Employe create(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public Employe update(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> getAll() {
		return employeRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		employeRepository.deleteById(id);	
	}

	@Override
	public Employe findByUsername(String username) {
		return employeRepository.findByUsername(username).get();
	}

	@Override
	public Employe findByEmail(String email) {
		return employeRepository.findByEmail(email).get();
	}

	@Override
	public Employe findById(Long id) {
		 return employeRepository.findById(id).get();
	}

}
