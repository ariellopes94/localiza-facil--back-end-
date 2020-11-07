package com.localize.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localize.domain.Bairro;
import com.localize.repositories.BairroRepository;

@Service
public class BairroService {

	@Autowired
	private BairroRepository bairroRepository;
	
	
	public Bairro create(Bairro bairro) {
		bairro.setId(null);	
		return bairroRepository.save(bairro);
	}
	
}
