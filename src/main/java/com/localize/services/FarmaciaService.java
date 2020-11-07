package com.localize.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localize.domain.Bairro;
import com.localize.domain.Farmacia;
import com.localize.repositories.FarmaciaRepository;
import com.localize.services.exceptions.FarmaciaNaoEncontradoException;

@Service
public class FarmaciaService {
	
	@Autowired
	private FarmaciaRepository farmaciaRepository;
	
	public Farmacia create(Farmacia farmacia) {
		farmacia.setId(null);
		return  farmaciaRepository.save(farmacia);
	}

	public void delete(Long id) {
		verificarExistencia(id);
		farmaciaRepository.deleteById(id);
	}
	
	
	
	public Farmacia verificarExistencia(Long id) {
		   Optional<Farmacia> obj = farmaciaRepository.findById(id);
		   Farmacia farmacia =  obj.orElse(null);
		   
		   if(farmacia == null) {
			   throw new FarmaciaNaoEncontradoException("A Farmacia não pôde ser encontrado.");
		   }
			 return farmacia;
		}
}
