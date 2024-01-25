package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Num;
import org.java.spring.db.serv.NumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private NumService numService;
	
	@GetMapping
	public String getIndex(Model model) {
		
		List<Num> nums = numService.findAll();
		
		model.addAttribute("nums", nums);
		
		return "index";
	}
}
