package com.example.Gabriel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gabriel.dto.DeliveryDTO;
import com.example.Gabriel.entities.EntityDelivery;
import com.example.Gabriel.reposioties.DeliveryReposities;
import com.example.Gabriel.util.Converter;

@Service
public class DeliveryService {
	private DeliveryReposities delivery;
	private Converter converter;
	
	
	@Autowired
	public DeliveryService(DeliveryReposities delivery) {
		this.delivery = delivery;
	}
	
	public DeliveryDTO findById(Integer code) {
		Optional<EntityDelivery> obj = delivery.findById(code);
		EntityDelivery entity = obj.orElseThrow();
		return Converter.toDTO(entity);
	}
	
	public void createDelivery(DeliveryDTO delivery) {
		delivery.equals(converter.toEntity(delivery, false));
	}
}
