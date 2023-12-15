package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping
	public String getPhotos(Model model, @RequestParam(required = false) String name) {
		
		List<Photo> photos = name == null
							? photoService.findAll()
							: photoService.findByName(name);
		
		model.addAttribute("photos", photos);
		model.addAttribute("name", name == null ? "" : name);
		
		return "photos";
	}
}
