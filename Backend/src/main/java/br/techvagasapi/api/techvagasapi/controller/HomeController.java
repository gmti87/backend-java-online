package br.techvagasapi.api.techvagasapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "🚀 API Tech Vagas em funcionamento!!";
	}

}
