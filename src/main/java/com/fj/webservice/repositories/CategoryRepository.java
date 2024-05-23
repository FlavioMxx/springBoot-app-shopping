package com.fj.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fj.webservice.entities.Category;

//@Repository é opcional, pois JpaRepository já "contém";
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
