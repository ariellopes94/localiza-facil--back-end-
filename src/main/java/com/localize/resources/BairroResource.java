package com.localize.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "bairros")
public class BairroResource  {
	
	@GetMapping
	public String bairros() {
		return "Testando Rest";
	}

}
