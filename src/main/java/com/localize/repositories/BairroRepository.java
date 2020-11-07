package com.localize.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.localize.domain.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

	Bairro findByNameIgnoreCase(String name);
	
	long count();
}
