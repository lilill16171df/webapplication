package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.PhonebookVO;
import com.example.demo.service.PhonebookService;

@Controller
public class MainController {
	
	@Autowired
	private PhonebookService service;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("phonebookList", service.selectAll());
		
		return "index";
	}
	
	
	// OK
	@PostMapping("create")
	public String create(PhonebookVO phonebook) {
		
		System.out.println(phonebook);
		
		service.insert(phonebook);
		
		return "redirect:/";
	}
	
	@PostMapping("update")
	public String update(PhonebookVO phonebook) {
		
		System.out.println(phonebook);
		
		service.update(phonebook);
		
		return "redirect:/";
	}
	
	@PostMapping("delete")
	public String delete(PhonebookVO phonebook) {
		
		service.delete(phonebook.getId());
		
		return "redirect:/";
	}
	
	// OK
	@PostMapping("search")
	public String search(Model model, String search) {
		
		System.out.println(search);
		
		model.addAttribute("phonebookList", service.search(search));
		
		return "index";
	}
	
	
	
}
