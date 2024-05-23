package com.fj.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fj.webservice.entities.OrderItem;

//@Repository é opcional, pois JpaRepository já "contém";
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
