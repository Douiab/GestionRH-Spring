package com.example.gestionRH.controller;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.gestionRH.entites.Departement;
import com.example.gestionRH.entites.Employe;
import com.example.gestionRH.entites.Remuneration;
import com.example.gestionRH.entites.Role;
import com.example.gestionRH.service.DepartementService;
import com.example.gestionRH.service.EmployeService;
import com.example.gestionRH.service.RemunerationService;
import com.example.gestionRH.utils.EncrytedPasswordUtils;

@Controller
@RequestMapping("/employes")
public class EmployeController {

	@Autowired
	EmployeService employeService;

	@Autowired
	DepartementService departementService;
	
	@Autowired
	RemunerationService remunerationService;
	
	@ModelAttribute("allDepartements")
	public List<Departement> allDepartements() {
		List<Departement> departements = departementService.getAll();
	    return departements;
	}
	
	@ModelAttribute("allRemuneration")
	public List<Remuneration> allRemuneration() {
		List<Remuneration> remunerations = remunerationService.getAll();
	    return remunerations;
	}


	@GetMapping
	public String getAll(Model model) {
		List<Employe> employes = employeService.getAll();
		model.addAttribute("liste", employes);
		return "employes";
	}

	@PostMapping("/saveEmploye")
	@Transactional
	public ModelAndView saveEmploye(@ModelAttribute Employe employe) {
		employe.setPassword(EncrytedPasswordUtils.encrytePassword(employe.getPassword()));
		if(employe.getUsername().equals("admin")) {
			Role role = new Role();
			role.setId(2);
			employe.setRole(role);
		} else {
			Role role = new Role();
			role.setId(1);
			employe.setRole(role);
		}
		employeService.update(employe);
		return new ModelAndView("redirect:/employes");
	}

	@GetMapping("/addEmploye")
	public String create(Model model) {
		Employe employe = new Employe();
		model.addAttribute("employe", employe);
		List<Employe> employes = employeService.getAll();
		model.addAttribute("liste", employes);
		return "addEmploye";
	}

	@GetMapping("/updateEmploye")
	public String update(@RequestParam(value = "id") Long id, Model model) {
		Employe employe = employeService.findById(id);
		model.addAttribute("employe", employe);
		List<Employe> employes = employeService.getAll();
		model.addAttribute("liste", employes);
		return "addEmploye";
	}

	@GetMapping("/{id}")
	public String getEmployeById(@PathVariable(value = "id") Long id, Model model) {
		Employe employe = employeService.findById(id);
		model.addAttribute("employe", employe);
		return "detailEmploye";
	}
	
	@GetMapping("/deleteEmploye")
	public ModelAndView deleteEmploye(@RequestParam(value = "id") Long id, Model model) {
		employeService.delete(id);
		return new ModelAndView("redirect:/employes");
	}
	
	@GetMapping("/listSousJacents")
	public String getListSousJacentsByEmployeId(@RequestParam(value = "id") Long id, Model model) {
		Employe sousjacent = new Employe();
		model.addAttribute("sousJacent", sousjacent);
		List<Employe> employes = employeService.getAll();
		model.addAttribute("employes", employes);
		Employe employe = employeService.findById(id);
		model.addAttribute("employe", employe);
		Set<Employe> liste = employe.getSousjacents();
		model.addAttribute("liste", liste);
		return "listSousJacents";
	}
	
	
	@GetMapping("/deleteSousJacent")
	public ModelAndView deleteSousJacent(@RequestParam(value = "id") Long id, @RequestParam(value = "idSousJacent") Long idSousJacent, Model model) {
		Employe employe = employeService.findById(id);
		Employe sousJacent = employeService.findById(idSousJacent);
		model.addAttribute("employe", employe);
		employe.getSousjacents().remove(sousJacent);
		employeService.update(employe);
		return new ModelAndView("redirect:/employes/listSousJacents" + "?id=" + id);
	}
	
	@PostMapping("/addSousJacent")
	@Transactional
	public ModelAndView addSousJacent(@ModelAttribute Employe sousJacent, @RequestParam(value = "idSup") Long idSup) {
		Employe employe = employeService.findById(idSup);
		employe.getSousjacents().add(sousJacent);
		employeService.update(employe);
		return new ModelAndView("redirect:/employes/listSousJacents" + "?id=" + idSup);
	}
	
	
	

}
