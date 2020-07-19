package com.example.gestionRH.controller;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.gestionRH.entites.Departement;
import com.example.gestionRH.enumeration.TypeDepartement;
import com.example.gestionRH.service.DepartementService;

@Controller
@RequestMapping("/departements")
public class DepartementController {

	@Autowired
	DepartementService departementService;
	
	@ModelAttribute("allDepartements")
	public List<Departement> allDepartements() {
		List<Departement> departements = departementService.getAll();
	    return departements;
	}
	
	@ModelAttribute("enumTypeDepartement")
	public TypeDepartement[] enumTypeDepartement() {
//		List<Departement> departements = departementService.getAll();
	    return TypeDepartement.values();
	}
	
	@GetMapping
	public String getAll(Model model) {
		Departement departement = new Departement();
		model.addAttribute("departement", departement);
		return "departements";
	}

	@PostMapping("/saveDepartement")
	@Transactional
	public ModelAndView saveDepartement(@ModelAttribute Departement departement) {
		departementService.create(departement);
		return new ModelAndView("redirect:/departements");
	}

//	@GetMapping("")
//	public ModelAndView update(@RequestParam(value = "id") Long id, Model model) {
//		Departement departement = departementService.getById(id);
//		model.addAttribute("departement", departement);
//		return new ModelAndView("redirect:/departements");
//	}
	
	@GetMapping("/deleteDepartement")
	public ModelAndView deleteDepartement(@RequestParam(value = "id") Long id, Model model) {
		departementService.delete(id);
		return new ModelAndView("redirect:/departements");
	}
	
	@GetMapping("/updateDepartement")
	public String updateDepartement(@RequestParam(value = "id") Long id, Model model) {
		Departement departement = departementService.getById(id);
		model.addAttribute("departement", departement);
		return "departements";
	}
}
