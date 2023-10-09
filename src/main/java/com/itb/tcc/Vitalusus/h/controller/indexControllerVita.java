package com.itb.tcc.Vitalusus.h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Vitalusus-2h")
public class indexControllerVita {
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
}
