package com.localize.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localize.domain.Bairro;
import com.localize.repositories.BairroRepository;
import com.localize.services.exceptions.ObjectNotFoundException;
import com.localize.services.exceptions.ObjetoExistenteException;

@Service
public class BairroService {

	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired 
	private UteisService uteisService;
	
	public Bairro create(Bairro bairro) {
		bairro.setId(null);	
		Bairro obj = bairroRepository.findByNameIgnoreCase(uteisService.removeAccents(bairro.getName()));
		 
		if(obj != null) {
			throw new ObjetoExistenteException("Bairro já Existe");
		
		}
		
		return bairroRepository.save(bairro);
	}
	
	public List<Bairro> findByAll(){
		
		 List<Bairro> obj = bairroRepository.findAll();
		 
		   
		   if(obj == null) {
			   throw new ObjectNotFoundException("Não contem bairros");
		   }
			 return obj;
	}
	
	public List<Bairro> findByBairroContains(String nome){
		
		 List<Bairro> obj = bairroRepository.findTop6ByNameContaining(nome);
		   if(obj.isEmpty() == true) {
			   throw new ObjectNotFoundException("Não contem bairro com o nome Informado");
		   }
			 return obj;
	}
	
	
}
