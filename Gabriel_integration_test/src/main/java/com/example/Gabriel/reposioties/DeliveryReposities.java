package com.example.Gabriel.reposioties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gabriel.entities.EntityDelivery;

@Repository
public interface DeliveryReposities extends JpaRepository<EntityDelivery, Integer> {

	public List<EntityDelivery> findByActive(boolean active);
	
}
