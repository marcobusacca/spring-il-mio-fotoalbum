package org.java.spring.controller;

import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhotoController {

	@Autowired
	private PhotoService photoService;
}
