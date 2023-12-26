package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.serv.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	private NumberService numberService;
	
	@GetMapping
	public String getIndex(Model model) {
		
		List<org.java.spring.db.pojo.Number> numbers = numberService.findAll();
		
		model.addAttribute("numbers", numbers);
		
		return "index";
	}
}
