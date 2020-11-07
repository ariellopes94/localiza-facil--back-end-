package com.localize.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localize.domain.Bairro;
import com.localize.repositories.BairroRepository;
import com.localize.services.exceptions.ObjetoExistenteException;

@Service
public class BairroService {

	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired 
	private UteisService uteisService;
	
	public Bairro create(Bairro bairro) {
		bairro.setId(null);	
		
		//System.out.println("VALIDAR " + bairroRepository.findByNameIgnoreCase(uteisService.removeAccents(bairro.getName())).isPresent());
		
		Bairro obj = bairroRepository.findByNameIgnoreCase(uteisService.removeAccents(bairro.getName()));
		 
		if(obj != null) {
			throw new ObjetoExistenteException("Bairro já Existe");
		
		}
		
		return bairroRepository.save(bairro);
	}
	
	
	
}
