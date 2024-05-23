package com.fj.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fj.webservice.entities.User;

//@Repository é opcional, pois JpaRepository já "contém";
public interface UserRepository extends JpaRepository<User, Long>{
	
}
