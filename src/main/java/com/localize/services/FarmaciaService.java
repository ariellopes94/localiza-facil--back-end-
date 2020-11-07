package com.localize.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localize.domain.Farmacia;
import com.localize.repositories.FarmaciaRepository;

@Service
public class FarmaciaService {
	
	@Autowired
	private FarmaciaRepository farmaciaRepository;
	
	public Farmacia create(Farmacia farmacia) {
		farmacia.setId(null);
		return  farmaciaRepository.save(farmacia);
	}

	
}
