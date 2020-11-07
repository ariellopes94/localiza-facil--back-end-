package com.localize.repositories;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.localize.domain.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

	//@Transactional(readOnly =true)
	Optional<Bairro> findByNameIgnoreCase(String name);
}
