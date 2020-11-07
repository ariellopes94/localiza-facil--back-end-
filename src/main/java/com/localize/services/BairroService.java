package com.localize.services;

import java.text.Normalizer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localize.domain.Bairro;
import com.localize.repositories.BairroRepository;
import com.localize.services.exceptions.BairroExistenteException;

@Service
public class BairroService {

	@Autowired
	private BairroRepository bairroRepository;
	
	
	public Bairro create(Bairro bairro) {
		bairro.setId(null);	
		
		 
		 //String removerAcentos = removeAccents(bairro.getName());
		 
	//	Boolean palavraJaExiste;
		
		// palavraJaExiste = ;
		 
		
		if(bairroRepository.findByNameIgnoreCase(removeAccents(bairro.getName())).isPresent() == true) {
			throw new BairroExistenteException("Bairro já Existe");
		
		}
		
		 
		return bairroRepository.save(bairro);
	}
	
	private static String removeAccents(String str) {
	    str = Normalizer.normalize(str, Normalizer.Form.NFD);
	    str = str.replaceAll("[^\\p{ASCII}]", "");
	    return str;
	}
	
}
