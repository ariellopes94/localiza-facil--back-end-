package com.localize.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.localize.domain.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
	
	// Farmacia findByNameIgnoreCase(String name);
	
	Farmacia findByNameIgnoreCase(String name);
	//boolean existsByName(String nome);
	//List<Farmacia> findTop2ByNameContaining(String nome);
}
