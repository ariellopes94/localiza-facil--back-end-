package com.localize.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.localize.domain.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
	
	// Farmacia findByNameIgnoreCase(String name);
	
	Farmacia findByNameIgnoreCase(String name);
	
	List<Farmacia> findTop6ByNameContaining(String nome);

	//Consultar Farmacia por Bairro
	// List<Farmacia> findByBairroLocalizadoId(Long id);
	
	 List<Farmacia> findByBairroLocalizadoIdAndFarmacia24Horas(Long id, boolean faramacia24Horas);
	
	
	//boolean existsByName(String nome);
	//List<Farmacia> findTop2ByNameContaining(String nome);
}
