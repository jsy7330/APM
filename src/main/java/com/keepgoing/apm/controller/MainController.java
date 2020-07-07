package com.keepgoing.apm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.keepgoing.apm.service.MainService;

@Controller
@SpringBootApplication
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired MainService mainService;
	
	@RequestMapping(value="/")
	public String main(Model model) throws Exception {
		
		log.info("###main###");
		model.addAttribute("timeView", mainService.getUserInfo());
		return "main/main";
	}
}
