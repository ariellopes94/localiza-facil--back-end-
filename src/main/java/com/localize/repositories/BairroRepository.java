package com.localize.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.localize.domain.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

	Bairro findByNameIgnoreCase(String name);
	
	List<Bairro> findTop6ByNameContaining(String nome); //Consulta com %Like% Retorno Máximo 6
	
	long count();
}
