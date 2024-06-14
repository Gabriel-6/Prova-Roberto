package com.example.Gabriel.service;

import java.util.Optional;

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
	public DeliveryService(DeliveryReposities delivery, Converter converter) {
		this.delivery = delivery;
		this.converter = converter;
	}

	public DeliveryDTO findById(Integer code) {
		Optional<EntityDelivery> obj = delivery.findById(code);
		EntityDelivery entity = obj.orElseThrow();
		return Converter.toDTO(entity);
	}

	public void createDelivery(DeliveryDTO deliveryDTO) {
		EntityDelivery entity = Converter.toEntity(deliveryDTO, true);
		delivery.save(entity);
	}
}
