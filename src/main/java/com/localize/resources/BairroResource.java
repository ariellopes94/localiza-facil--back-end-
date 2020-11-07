package com.localize.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.localize.domain.Bairro;
import com.localize.repositories.BairroRepository;
import com.localize.services.BairroService;

@RestController
@RequestMapping(value = "bairro")
public class BairroResource  {
	
	@Autowired
	private BairroService bairroService;
	
	@Autowired
	private BairroRepository bairroRepository;
	
	@GetMapping
	public String bairros() {
		return "Testando Rest";
	}

	@PostMapping
	public ResponseEntity<Bairro> create(@Valid @RequestBody Bairro bairro){
		Bairro obj = bairroService.create(bairro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/totalFarmacias")
	public long famarciaTotal () {
		return bairroRepository.count();
	}
}
