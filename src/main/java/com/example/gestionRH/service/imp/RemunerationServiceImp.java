package com.example.gestionRH.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionRH.entites.Remuneration;
import com.example.gestionRH.repository.RemunerationRepository;
import com.example.gestionRH.service.RemunerationService;

@Service
public class RemunerationServiceImp  implements RemunerationService{
	
	@Autowired
	RemunerationRepository remunerationRepository;

	@Override
	public Remuneration create(Remuneration remuneration) {
		return remunerationRepository.save(remuneration);
	}

	@Override
	public Remuneration update(Remuneration remuneration) {
		return remunerationRepository.save(remuneration);
	}

	@Override
	public List<Remuneration> getAll() {
		return remunerationRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		remunerationRepository.deleteById(id);
	}

	@Override
	public Remuneration getById(Long id) {
		return remunerationRepository.getOne(id);
	}

}
