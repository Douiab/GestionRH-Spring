package com.example.gestionRH.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.gestionRH.entites.Departement;
import com.example.gestionRH.entites.Employe;
import com.example.gestionRH.service.DepartementService;
import com.example.gestionRH.service.EmployeService;
import com.example.gestionRH.utils.WebUtils;

@Controller
public class MainController {

	@Autowired
	EmployeService employeService;
	
	@Autowired
	DepartementService departementService;
	
	@ModelAttribute("allDepartements")
	public List<Departement> allDepartements() {
		List<Departement> departements = departementService.getAll();
	    return departements;
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "index";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "login";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtils.toString(loginedUser);
			model.addAttribute("userInfo", userInfo);
			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);
		}

		return "403Page";
	}

	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String profil(Model model, Principal principal) {
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			Employe userInfo = employeService.findByUsername(loginedUser.getUsername());
			model.addAttribute("userInfo", userInfo);
		}
		return "profil";
	}

}