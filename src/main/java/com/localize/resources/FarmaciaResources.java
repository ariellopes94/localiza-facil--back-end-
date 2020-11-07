package com.localize.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.localize.domain.Farmacia;
import com.localize.repositories.FarmaciaRepository;

@RestController
@RequestMapping(value = "farmacia")
public class FarmaciaResources {
	
	@Autowired
	private FarmaciaRepository farmaciaRepository;

	@PostMapping
	public ResponseEntity<Farmacia> create(@Valid @RequestBody Farmacia farmacia){
		
		Farmacia obj = farmaciaRepository.save(farmacia);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
}
