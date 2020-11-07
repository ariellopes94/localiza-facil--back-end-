package com.localize.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.localize.domain.Farmacia;
import com.localize.domain.assembler.FarmaciaModelAssembler;
import com.localize.domain.dto.FarmaciaDto;
import com.localize.services.FarmaciaService;
import com.localize.services.exceptions.FarmaciaNaoPodeSerExcluidaException;

@RestController
@RequestMapping(value = "farmacia")
public class FarmaciaResources {
	
	@Autowired
	private FarmaciaService farmaciaService;
	
	@Autowired
	private FarmaciaModelAssembler farmaciaModelAssembler;

	@PostMapping
	public ResponseEntity<Farmacia> create(@Valid @RequestBody Farmacia farmacia){
		
		Farmacia obj = farmaciaService.create(farmacia);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<FarmaciaDto> findById(@PathVariable Long id){
		Farmacia obj = farmaciaService.findById(id);
		return ResponseEntity.ok().body(farmaciaModelAssembler.modelFarmaciaToFarmaciaDto(obj));	
	}
	
	@PutMapping(value = "/{id}")   
	public ResponseEntity<Farmacia> atualizarLivro(@RequestBody Farmacia farmacia, @PathVariable Long id) {
		farmacia.setId(id);
		farmaciaService.edit(farmacia);	
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		Farmacia obj = farmaciaService.findById(id);
		FarmaciaDto objDto = farmaciaModelAssembler.modelFarmaciaToFarmaciaDto(obj);
		
		if(objDto.isFundadaMaisDe1Ano() == true) {
			  throw new FarmaciaNaoPodeSerExcluidaException("A Farmacia não pôde ser excluida,pois foi fundada há mais de 1 ano.");
		}
			
		farmaciaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
