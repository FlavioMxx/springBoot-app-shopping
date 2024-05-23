package com.fj.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fj.webservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
