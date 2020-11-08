package com.localize.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.localize.domain.Bairro;
import com.localize.domain.Farmacia;
import com.localize.repositories.FarmaciaRepository;
import com.localize.services.exceptions.ObjectNotFoundException;
import com.localize.services.exceptions.ObjetoExistenteException;

@Service
public class FarmaciaService {
	
	@Autowired
	private FarmaciaRepository farmaciaRepository;
	
	
	public Farmacia create(Farmacia farmacia) {
		farmacia.setId(null);
		
		verificarExistencia(farmacia.getName());
		return  farmaciaRepository.save(farmacia);
	}

	@Transactional
	public void delete(Long id) {
		findById(id);
		farmaciaRepository.deleteById(id);
	}
	
	@Transactional
	public Farmacia findById(Long id) {
		   Optional<Farmacia> obj = farmaciaRepository.findById(id);
		   Farmacia farmacia =  obj.orElse(null);
		   
		   if(farmacia == null) {
			   throw new ObjectNotFoundException("A Farmacia não pôde ser encontrado.");
		   }
			 return farmacia;
		}
	
	public void edit(Farmacia famarcia) {
		
		findById(famarcia.getId());
		
	
		Farmacia obj = farmaciaRepository.findByNameIgnoreCase(famarcia.getName());
		
		if(obj != null && obj.getId() != famarcia.getId()) {
			throw new ObjetoExistenteException("Farmacia já Existe");
		}
	
	//	System.out.println(farmaciaRepository.existsByName(famarcia.getName()));
		farmaciaRepository.save(famarcia);
	}
	
	
	public List<Farmacia> findByAll(){
		
		 List<Farmacia> obj = farmaciaRepository.findAll();
		   if(obj == null) {
			   throw new ObjectNotFoundException("Não contem Farmacia");
		   }
			 return obj;
	}
	

	@Transactional
	public void verificarExistencia(String nome) {
		
		Farmacia obj = farmaciaRepository.findByNameIgnoreCase(nome);
		
		if(obj != null) {
			throw new ObjetoExistenteException("Farmacia já Existe");
		}
	}
}
