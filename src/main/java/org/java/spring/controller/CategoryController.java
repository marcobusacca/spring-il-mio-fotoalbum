package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.serv.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;
	
	@GetMapping
	public String getCategories(Model model) {
		
		List<Category> categories = categoryService.findAll();
		
		model.addAttribute("categories", categories);
		
		return "categories";
	}
}
