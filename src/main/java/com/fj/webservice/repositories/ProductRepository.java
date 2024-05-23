package com.fj.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fj.webservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
