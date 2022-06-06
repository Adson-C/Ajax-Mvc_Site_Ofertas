package com.ads.adsajaxspringboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomerController {
	
	@GetMapping("/")
	public String init() {
		return "redirect:/promocao/add"; // a class raiz da aplicação
	}

}

